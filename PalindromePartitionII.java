public class Solution {
    //TLE problem, fuck...!
    //this is the dfs method
    HashMap<String, Integer> map=new HashMap<String, Integer>();
    HashMap<String, Boolean> p=new HashMap<String, Boolean>();
    public int minCut1(String s) {
        if(map.containsKey(s)) return map.get(s);
        int result=Integer.MAX_VALUE;
        if(s==null||s.length()<2) return 0;
        for(int i=1; i<s.length()-1; i++){
            String left=s.substring(0, i);
            if(isPalindrome(left)){
                String right=s.substring(i);
                int r=1+minCut(right);
                result=Math.min(result, r);
            }
        }

        map.put(s, result);
        return result;
    }
    
    public boolean isPalindrome(String s){
        if(p.containsKey(s)) return p.get(s);
        int n=s.length();
        if(n==0||n==1){
            p.put(s, true);
            return true;
        }else{
            if(s.charAt(0)!=s.charAt(n-1)){
                p.put(s, false);
                return false;
            }else{
                String remain=s.substring(1, n-1);
                boolean b=isPalindrome(remain);
                p.put(s, b);
                return b;
            }
            
        }
    }
    
    //O(n^2) time and space
    //similar to the bottom up idea of find the longest palindrome substring
    public int minCut(String s) {
        if(s==null||s.length()<2) return 0;
        int n=s.length();
        boolean[][] b=new boolean[n][n];
        int[] c=new int[n];
        for(int i=0; i<n; i++){
            c[i]=i;
            for(int j=0; j<n;j++){
                if(i<=j) b[j][i]=true;
            }
        }
        
        for(int i=1; i<n;i++){
            char c1=s.charAt(i);
            //find the min cut in substring 0->i:
            //need to cut before any char from 0 to i
            c[i]=Math.min(1+c[i-1], c[i]);
            //always make mistake here....
            //when j ends at 0, it should be --, not ++!!!
            for(int j=i-1; j>=0; j--){
                char c2=s.charAt(j);
                if(c1==c2&&b[j+1][i-1]){
                    int cut=(j>0)?1+c[j-1]:0;
                    c[i]=Math.min(c[i], cut);
                    //dont forget to update the boolean table here!!!!!
                    b[j][i]=true;
                }
            }
        }
        return c[n-1];
    }
}
