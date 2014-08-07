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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        
        int left=-1;
        int right=-1;
        if(root.left!=null)
            left=maxDepth(root.left);
        if(root.right!=null)
            right=maxDepth(root.right);
        
        if(left>0&&right>0)
            return Math.max(left, right)+1;
        else{
            return (left>0)?left+1:right+1;
        }
    }
}
