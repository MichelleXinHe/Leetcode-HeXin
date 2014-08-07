//it is similar to the question of rotate image
//use layer concept
//since the matrix is M*N: the difficulty is to find out the number of layers
public class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        List<Integer> list=new ArrayList<Integer>();
        if(m==null||m.length==0) return list;
        int maxLayer=0;
        //just base on case in case analysis, find out that except only one row or one column
        //the number of layers always=min(m, n)-1
        if(m.length==1||m[0].length==1) maxLayer=1;
        else maxLayer=Math.min(m.length, m[0].length)-1;
        //no equality for layer here!!!
        for(int layer=0; layer<maxLayer; layer++){
            //define the boundry of this layer
            int startRow=layer, startCol=layer;
            int lastRow=m.length-1-startRow;
            int lastCol=m[0].length-1-startCol;
            //top row
            for(int i=startCol; i<=lastCol; i++)
                list.add(m[startRow][i]);
            //right
            for(int i=startRow+1; i<=lastRow; i++)
                list.add(m[i][lastCol]);
            
            //if this is a single column, no need to go through again
            //bottom
            if(startRow!=lastRow){
                for(int i=lastCol-1; i>=startCol;i--)
                    list.add(m[lastRow][i]);
            }
            //left
            if(startCol!=lastCol){
                for(int i=lastRow-1; i>startRow; i--)
                    list.add(m[i][startCol]);
            }
        }
        return list;
    }
}
