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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(root==null) return list;
        List<Integer> p=new ArrayList<Integer>();
        List<TreeNode> parent=new ArrayList<TreeNode>();
        p.add(root.val);
        parent.add(root);
        while(parent.size()>0){
            list.add(p);
            p=new ArrayList<Integer>();
            List<TreeNode> current=new ArrayList<TreeNode>();
            for(TreeNode n:parent){
                if(n.left!=null){
                    p.add(n.left.val);
                    current.add(n.left);
                }
                
                if(n.right!=null){
                    p.add(n.right.val);
                    current.add(n.right);
                }
                parent=current;
            }
        }
        return list;
    }
}
