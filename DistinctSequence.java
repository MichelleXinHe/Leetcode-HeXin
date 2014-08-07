//2D DP problem
//f[i][j]-how many times the first j chars in t contained in the first i chars of s
//if s[i]==t[j], f[i][j]+=f[i-1][j-1]
//no matter if s[i]!/==t[j], f[i][j]+=f[i-1][j]
public class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length(), n=t.length();
        if(m<n) return 0;
        int[][] f=new int[m+1][n+1];
        //the initialization of array f
        //when substring of t is empty, there will be only one match from string s
        for(int i=0; i<=m;i++) f[i][0]=1;
        
        //i and j start from 1, but the index of character need substract one from them
        for(int i=1; i<=m;i++){
            char c1=s.charAt(i-1);
            for(int j=1; j<=n&&j<=i;j++){
                char c2=t.charAt(j-1);
                f[i][j]+=f[i-1][j];
                if(c1==c2) f[i][j]+=f[i-1][j-1];
            }
        }
        return f[m][n];
    }
}
