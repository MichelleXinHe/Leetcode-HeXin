//the basic idea and method is correct, but when implementing search(), some base cases and details need to be watched out
public class Solution {
    public boolean exist(char[][] b, String s) {
        char[] c=s.toCharArray();
        int m=b.length, n=b[0].length;
        if(m*n<s.length()) return false;
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(c[0]!=b[i][j]) continue;
                boolean[][] f=new boolean[m][n];
                boolean result=search(i, j, b, c, 0, f);
                if(result) return true;
            }
        }
        return false;
    }
    
    public boolean search(int row, int col, char[][] b, char[] c, int index, boolean[][] f){
        int m=b.length, n=b[0].length;
        //converge condition here!
        if(index==c.length) return true;
        //out of the boundry
        if(row<0||row>=m||col<0||col>=n) return false;
        //already used
        if(f[row][col]) return false;
        //not equal to the current index
        if(b[row][col]!=c[index]) return false;
        
        f[row][col]=true;
        boolean result=search(row-1, col, b, c, index+1, f)||search(row+1, col, b, c, index+1, f)||search(row, col-1, b, c, index+1, f)||search(row, col+1, b, c, index+1, f);
        f[row][col]=false;
        return result;
    }
}
