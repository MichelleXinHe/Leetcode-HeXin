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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        if(root==null) return result;
        List<Integer> p= new ArrayList<Integer>();
        List<TreeNode> parent= new ArrayList<TreeNode>();
        p.add(root.val);
        parent.add(root);
        while(parent.size()>0){
            result.add(0, p);
            List<Integer> c= new ArrayList<Integer>();
            List<TreeNode> current= new ArrayList<TreeNode>();
            for(TreeNode n: parent){
                if(n.left!=null){
                    c.add(n.left.val);
                    current.add(n.left);
                }
                if(n.right!=null){
                    c.add(n.right.val);
                    current.add(n.right);
                }
            }
            p=c;
            parent=current;
        }
        
        return result;
    }
}
