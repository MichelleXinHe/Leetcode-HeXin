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
    //two stacks
    //first stack-similar to the preorder traverse-reversed post order-left first then right
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> s1=new Stack<TreeNode>();
        Stack<TreeNode> s2=new Stack<TreeNode>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode n=s1.pop();
            if(n.left!=null) s1.push(n.left);
            if(n.right!=null) s1.push(n.right);
            s2.push(n);
        }
        
        while(!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode current=root;
        while(!s.isEmpty()||current!=null){
            if(current!=null){
                if(current.right!=null) s.push(current.right);
                s.push(current);
                current=current.left;
            }else{
                current=s.pop();
                if(current.right==null){
                    list.add(current.val);
                    current=null;
                }else{
                    TreeNode n=s.peek();
                    if(current.right==n){
                        n=s.pop();
                        current.right=null;
                        s.push(current);
                        current=n;
                    }
                }
            }            
        }
        return list;
    }

}
