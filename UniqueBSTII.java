//one dimension DP problem
//similar to climbing stairs
//f[i]-is the # of how many unique BST with i node
//it doesnt matter if it is from 0-i or i-2i
public class Solution {
    public int numTrees(int n) {
        if(n<0) return 0;
        if(n<2) return 1;
        int[] f=new int[n+1];
        //0-empty tree, one unique representation. so is n=1
        f[0]=1;
        f[1]=1;
        for(int i=2; i<=n;i++){
            for(int j=0; j<i;j++) f[i]+=f[j]*f[i-1-j];
        }
        return f[n];
    }
}
