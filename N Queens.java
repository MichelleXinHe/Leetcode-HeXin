public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> list=new ArrayList<String[]>();
        if(n<=0) return list;
        int[] b=new int[n];
        init(b);
        put(b, 0, n, list);
        return list;
    }
    
    public void init(int[] b){
        for(int i=0; i<b.length; i++)
            b[i]=-1;
    }
    
    public void put(int[] b, int row, int n, ArrayList<String[]> list){
        if(row==n){
        	String[] board=convert(b);
            list.add(board);
            //need to return here!!!
            return;
        }
        
        for(int i=0; i<n; i++){
            //only when the queue can be put in this cell
            //put the queue and continue to the next row
            //otherwise stay on this row
            if(check(b, row, i)){
                b[row]=i;
                put(b, row+1, n, list);
            }
        }
    }
    
    public String[] convert(int[] b){
    	StringBuffer s=new StringBuffer();
    	String[] result=new String[b.length];
    	for(int i=0; i<b.length; i++){
    		s.append(".");
    	}
    	for(int i=0; i<b.length; i++){
    		char[] row=s.toString().toCharArray();
    		row[b[i]]='Q';
    		result[i]=new String(row);
    	}
    	return result;
    	
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
