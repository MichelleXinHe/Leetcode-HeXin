/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //pre order traverse
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root!=null&&root.left==null&&root.right==null&&root.val==sum) return true;
        boolean left=hasPathSum(root.left, sum-root.val);
        if(left) return true;
        
        return hasPathSum(root.right, sum-root.val);
    }
}
