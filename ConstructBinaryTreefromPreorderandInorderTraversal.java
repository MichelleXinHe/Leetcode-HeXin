/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode buildTree(int[] pre, int[] in) {
        if(in==null||pre==null) return null;
        int n=in.length;
        return buildTree(in, pre, 0, n-1, 0, n-1);
    }
    
    public TreeNode buildTree(int[] in, int[] pre, int is, int ie, int ps, int pe){
        if(is>ie||ps>pe) return null;
        if(is==ie) return new TreeNode(in[is]);
        TreeNode root=new TreeNode(pre[ps]);
        int i=is;
        while(i<=ie&&in[i]!=pre[ps]) i++;
        root.left=buildTree(in, pre, is, i-1, ps+1, ps+i-is);
        root.right=buildTree(in, pre, i+1, ie, ps+i-is+1, pe);
        return root;
    }
}
