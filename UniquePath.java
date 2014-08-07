public class Solution {
    //DP program
    //start from (0,0)
    public int uniquePaths(int m, int n) {
        int[][] ways=new int[m][n];
        sum(ways, 0, 0);
        return ways[0][0];
    }
    
    public int sum(int[][] w, int m, int n){
        //base cases are important!
        if(m>=w.length||n>=w[0].length) return 0;
        if(m==w.length-1&&n==w[0].length-1) w[m][n]=1;
        //use DP table before calculation
        if(w[m][n]>0) return w[m][n];
        if(m<w.length-1) w[m][n]+=sum(w, m+1, n);
        if(n<w[0].length-1) w[m][n]+=sum(w, m, n+1);
        return w[m][n];
    }
    
    //this is the bottom up DP
    public int uniquePaths1(int m, int n) {
        int[][] ways=new int[m][n];
        ways[m-1][n-1]=1;
        for(int i=m-1; i>=0;i--){
            for(int j=n-1; j>=0;j--){
                if(j+1<n) ways[i][j]+=ways[i][j+1];
                if(i+1<m) ways[i][j]+=ways[i+1][j];
            }
        }
        return ways[0][0];
    }
}
