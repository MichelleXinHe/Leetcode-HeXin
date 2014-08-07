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
    public TreeNode buildTree(int[] in, int[] post) {
        if(in==null||post==null) return null;
        int n=in.length;
        return buildTree(in, post, 0, n-1, 0, n-1);
    }
    
    public TreeNode buildTree(int[] in, int[] post, int is, int ie, int ps, int pe){
        int n=in.length;
        if(is>ie||ps>pe) return null;
        if(is==ie) return new TreeNode(in[ie]);
        
        TreeNode root=new TreeNode(post[pe]);
        int i=is; 
        while(i<=ie&&in[i]!=post[pe]) i++;
        //the difficulty is find out the boudry of in and post arrays in the recursive method
        //for array-in, this boundry can be easily defined with i, is, and ie
        //for array-post, the start of left is always ps, and the end of right is always pe-1
        //the other end of the interval needs use the fixed end with with the absolute length of sub array in
        root.left=buildTree(in, post, is, i-1, ps, ps-is+i-1);
        //
        //root.right=buildTree(in, post, i+1, ie, ps-is+i, pe-1);
        root.right=buildTree(in, post, i+1, ie, pe-1+i+1-ie, pe-1);

        return root;
    }
}
