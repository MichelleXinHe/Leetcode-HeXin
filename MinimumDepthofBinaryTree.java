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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        
        //if root has at least one null child, this root is not a leaf
        //need to find out the min Depth of this subtree
        int left=-1;
        int right=-1;
        if(root.left!=null)
            left=minDepth(root.left);
        if(root.right!=null)
            right=minDepth(root.right);
        if(left>0&&right>0)
            return Math.min(left, right)+1;
        else
            return (left>0)?left+1:right+1;
    }
}
