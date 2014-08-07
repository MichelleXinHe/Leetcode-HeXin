/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BTPreOrder {
    //with stack
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        if(root==null) return list;
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode n=s.pop();
            list.add(n.val);
            if(n.right!=null) s.push(n.right);
            if(n.left!=null) s.push(n.left);
        }
        return list;
    }
    
    //morris traversal
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        TreeNode current=root;
        while(current!=null){
            if(current.left==null){
                result.add(current.val);
                current=current.right;
            }else{
                TreeNode left=current.left;
                TreeNode temp=left;
                while(temp.right!=null&&temp.right!=current)
                    temp=temp.right;
                if(temp.right==null){
                    result.add(current.val);//dont forget to add the current value here
                    temp.right=current;
                    current=left;
                }else{
                    temp.right=null;
                    current=current.right;
                }
            }
        }
        return result;
    }
}
