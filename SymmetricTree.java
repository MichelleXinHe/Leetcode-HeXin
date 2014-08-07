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
    //recursive method
    //in-order traverse is enough- very elegant algorithm
    //left tree is in order, right tree is reversed in order
    //every time compare the two nodes that suppose to be the same
    public boolean isSymmetric1(TreeNode root) {
        if(root==null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode n1, TreeNode n2){
        if(n1==null&&n2==null) return true;
        if(n1==null||n2==null) return false;
        if(n1.val!=n2.val) return false;
        return helper(n1.left, n2.right)&&helper(n1.right, n2.left);
    }
    
    //iterative method- with 2 stacks
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> left=new Stack<TreeNode>();
        Stack<TreeNode> right=new Stack<TreeNode>();
        left.push(root.left);
        right.push(root.right);
        while(!left.isEmpty()&&!right.isEmpty()){
            TreeNode n1=left.pop();
            TreeNode n2=right.pop();
            if(n1!=null&&n2!=null){
                if(n1.val!=n2.val) return false;
                left.push(n1.left);
                left.push(n1.right);
                right.push(n2.right);
                right.push(n2.left);
            }else if(n1==null&&n2==null) continue;
            else return false;//only one of them is null
        }
        
        if(!left.isEmpty()||!right.isEmpty()) return false;
        return true;
    }
}
