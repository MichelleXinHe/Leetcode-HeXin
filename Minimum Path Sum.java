public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int r=grid.length, c=grid[0].length;
        int[][] m=new int[r][c];
        m[r-1][c-1]=grid[r-1][c-1];
        for(int i=r-1; i>=0; i--){
            for(int j=c-1; j>=0; j--){
                if((i+1<=r-1)&&(j+1<=c-1)) m[i][j]=grid[i][j]+Math.min(m[i+1][j], m[i][j+1]);
                else if(i+1<=r-1) m[i][j]=grid[i][j]+m[i+1][j];
                else if(j+1<=c-1) m[i][j]=grid[i][j]+m[i][j+1];
            }
        }
        return m[0][0];
    }
}
