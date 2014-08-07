//2D DP
//f[i][j]-the min distance of edit s(0, i) to t(0, j)
//if s.i==t.j f[i][j]=f[i-1][j-1]
//else (3 choices)
//1. insert a char=t.j after s.i 1+f[i][j-1]
//2. delete s.i 1+f[i-1][j]
//3. replace s.i==t.j 1+f[i-1][j-1]
public class Solution {
    public int minDistance(String s, String t) {
        if(s==null||t==null||s.equals(t)) return 0;
        int m=s.length(), n=t.length();
        int[][] f=new int[m+1][n+1];
        
        //init for the base cases
        for(int i=0; i<=m; i++) f[i][0]=i;
        for(int i=0; i<=n; i++) f[0][i]=i;
        
        for(int i=1; i<=m; i++){
            char c1=s.charAt(i-1);
            for(int j=1; j<=n; j++){
                char c2=t.charAt(j-1);
                if(c1==c2) f[i][j]=f[i-1][j-1];
                else{
                    int min=Math.min(f[i-1][j-1], Math.min(f[i][j-1], f[i-1][j]));
                    f[i][j]=1+min;
                }
            }
        }
        return f[m][n];
    }
}
