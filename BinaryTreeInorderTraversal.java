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
    //if current==null-pop, current=current.right
    //else push, current=curent.left
    //with stack
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        TreeNode current=root;
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(current!=null||s.size()>0){
            if(current==null){
                current=s.pop();
                list.add(current.val);
                current=current.right;
            }else{
                s.push(current);
                current=current.left;
            }
            
        }
        return list;
    }
    //morris inorder traverse
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        TreeNode current=root;
        while(current!=null){
            if(current.left==null){
                result.add(current.val);
                current=current.right;
            }else{//dont change the shape of the tree
                TreeNode left=current.left;
                TreeNode temp=left;
                while(temp.right!=null&&temp.right!=current) temp=temp.right;
                //the left part of current node is not visited
                if(temp.right==null){
                    temp.right=current;
                    current=left;
                }else{//already visited all the nodes on left of current, this is the 2nd time visiting current, so just print current
                    temp.right=null;
                    result.add(current.val);
                    current=current.right;
                }
            }
        }
        return result;
    }
}
