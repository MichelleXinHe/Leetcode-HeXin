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
    public boolean isBalanced(TreeNode root) {
        int result=check(root);
        if(result>=0) return true;
        else return false;
    }
    
    public int check(TreeNode root){
        if(root==null) return 0;
        
        int left=check(root.left);
        if(left==-1) return -1;
        int right=check(root.right);
        if(right==-1) return -1;
        int diff=Math.abs(left-right);
        if(diff>1) return -1;
        return Math.max(left, right)+1;
    }
}
