//http://yucoding.blogspot.com/2013/01/leetcode-question-27-interleaving-string.html
//this is the source of the DP program
//A[i][j]: S3[i+j] can be formed by S1[i] and S2[j] (for simplicity here string starts from 1, in the code we need to deal with that string starts from 0).

//So, we have the optimal function: A[i][j] =   (s3[i+j]==s1[i]  && a[i-1][j])  || (s3[i+j] ==s2[j] && a[i][j-1])

public class Solution {
    //this is the correct recursive method-without DP-TLE error here!!!
    public boolean isInterleave1(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null) return false;
        if((s1.length()+s2.length())!=s3.length()) return false;
        if(s1.length()==0||s2.length()==0){
            String s=(s1.length()==0)? s2:s1;
            return s3.equals(s);
        }
        
        char a=s3.charAt(0);
        char b=s1.charAt(0);
        char c=s2.charAt(0);
        return ((a==b)&&isInterleave(s1.substring(1), s2, s3.substring(1)))||((a==c)&&isInterleave(s1, s2.substring(1), s3.substring(1)));
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1==null||s2==null||s3==null) return false;
        int m=s1.length(), n=s2.length();
        if((m+n)!=s3.length()) return false;
        boolean[][] a=new boolean[m+1][n+1];
       
        //initialization
        a[0][0]=true;//trival base case 
        
        //notice i starts from 1 not 0!
        //the char start from s1 should be i-1
        //match with s1 without s2 involving
        //char i-1 in string s1 and s2 -> a[i][*]/a[*][i]
        for(int i=1; i<=m;i++){
            if(s1.charAt(i-1)==s3.charAt(i-1)&&a[i-1][0])   a[i][0]=true;
        }
        
        for(int i=1; i<=n;i++){
            if(s2.charAt(i-1)==s3.charAt(i-1)&&a[0][i-1])   a[0][i]=true;
        }
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                //compare s1[i] and s3[i+j], s1 must contribute i-1 chars before and the rest j chars from s2
                boolean b1=(s1.charAt(i-1)==s3.charAt(i+j-1))&&a[i-1][j];
                boolean b2=(s2.charAt(j-1)==s3.charAt(i+j-1))&&a[i][j-1];
                a[i][j]=b1||b2;
            }
        }
        return a[m][n];
    }

}
