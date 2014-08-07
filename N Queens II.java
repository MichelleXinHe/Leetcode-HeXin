public class Solution {
    int ways=0;
    public int totalNQueens(int n) {
        if(n<=0) return 0;
        int[] b=new int[n];
        init(b);
        put(b, 0, n);
        return ways;
    }
    
    public void init(int[] b){
        for(int i=0; i<b.length; i++)
            b[i]=-1;
    }
    
    public void put(int[] b, int row, int n){
        if(row==n){
            ways++;
            //need to return here!!!
            return;
        }
        
        for(int i=0; i<n; i++){
            //only when the queue can be put in this cell
            //put the queue and continue to the next row
            //otherwise stay on this row
            if(check(b, row, i)){
                b[row]=i;
                put(b, row+1, n);
            }
        }
    }
    
    public boolean check(int[] b, int row, int col){
        for(int i=0; i<row; i++){
            if(b[i]==col) return false;
            int rd=row-i;
            int cd=Math.abs(col-b[i]);
            if(cd==rd) return false;
        }
        return true;
    }
}
