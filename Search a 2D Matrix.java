public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, target, 0, matrix[0].length-1);
    }
    
    public boolean search(int[][] m, int t, int row, int col){
        int r=m.length;
        int c=m[0].length; 
        if((row>=r)||(col<0)) return false;
        if(m[row][col]==t) return true;
        else if(m[row][col]>t) return search(m, t, row, col-1);
        else return search(m, t, row+1, col);
    }
}
