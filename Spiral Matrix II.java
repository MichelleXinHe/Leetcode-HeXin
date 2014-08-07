public class Solution {
    public int[][] generateMatrix(int n) {
        if(n<0) return null;
        if(n==0){ 
            int[][] r={};
            return r;
        }
        int[][] result=new int[n][n];
        int i=1;
        for(int layer=0; layer<=n/2; layer++){
            int sr=layer, sc=layer, er=n-1-sr, ec=n-1-sc;
            for(int j=sc; j<=ec;j++){
                result[sr][j]=i;
                i++;
            }
            
            for(int j=sr+1; j<=er;j++){
                result[j][ec]=i;
                i++;
            }
            
            for(int j=ec-1; j>=sc; j--){
                result[er][j]=i;
                i++;
            }
            
            for(int j=er-1; j>sr;j--){
                result[j][sc]=i;
                i++;
            }
        }
        return result;
    }
}
