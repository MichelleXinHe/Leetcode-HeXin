/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //post order traverse
public class Solution {
    public int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        MP(root);
        return max;
    }
    
    public int MP(TreeNode root){
        if(root==null) return 0;
        int left=MP(root.left);
        int right=MP(root.right);
        int local=Math.max(Math.max(root.val, root.val+left+right),
                           Math.max(root.val+left, root.val+right));
        max=Math.max(max, local);
        return Math.max(root.val, root.val+Math.max(left, right));
    }
}
