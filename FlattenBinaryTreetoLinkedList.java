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
    public void flatten(TreeNode root) {
        if(root==null) return;
        
        if(root.left!=null){
            flatten(root.left);
            TreeNode right= root.right;
            root.right=root.left;
            //cut off the link to the original left!!!!!
            root.left=null;
            TreeNode temp=root;
            while(temp.right!=null)
                temp=temp.right;
            flatten(right);
            temp.right=right;
        }else
            flatten(root.right);
    }
}
