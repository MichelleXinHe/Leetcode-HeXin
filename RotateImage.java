public class Solution {
    public void rotate(int[][] m) {
        if(m==null||m.length<2) return;
        int n=m.length;
        for(int layer=0; layer<n/2;layer++){
            int col=layer;
            int end=n-1-layer;
            for(int j=col; j<end;j++){
                int temp=m[layer][j];
                m[layer][j]=m[n-1-j][col];
                m[n-1-j][col]=m[n-1-layer][n-1-j];
                m[n-1-layer][n-1-j]=m[j][n-1-col];
                m[j][n-1-col]=temp;
            }
        }
    }
}
