public class Solution {
    //the recursive method cannot pass because of TLE!
    //but the algorithm is correct
    public int uniquePathsWithObstacles1(int[][] grid) {
        if(grid==null) return 0;
        int m=grid.length, n=grid[0].length;
        int[][] w=new int[m][n];
        find(grid, w, 0, 0);
        return w[0][0];
    }
    
    public int find(int[][] grid, int[][] w, int m, int n){
        int row=grid.length, col=grid[0].length;
        if(m>=row||n>=col) return 0;
        if(w[m][n]>0||grid[m][n]==1) return w[m][n];
        if(m==row-1&&n==col-1) w[m][n]=1;

        if(m<row-1) w[m][n]+=find(grid, w, m+1, n);
        if(n<col-1) w[m][n]+=find(grid, w, m, n+1);
        return w[m][n];
    }
    
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        int[][] ways=new int[m][n];
        if(grid[m-1][n-1]==0) ways[m-1][n-1]=1;
        for(int i=m-1; i>=0;i--){
            for(int j=n-1; j>=0;j--){
                if(grid[i][j]==1) continue;
                if(j+1<n) ways[i][j]+=ways[i][j+1];
                if(i+1<m) ways[i][j]+=ways[i+1][j];
            }
        }
        return ways[0][0];
    }
}
