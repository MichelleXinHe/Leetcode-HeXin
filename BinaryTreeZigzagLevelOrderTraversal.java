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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        ArrayList<TreeNode> parent=new ArrayList<TreeNode>();
        parent.add(root);
        boolean b=false;
        while(parent.size()>0){
            ArrayList<TreeNode> current=new ArrayList<TreeNode>();
            ArrayList<Integer> list=new ArrayList<Integer>();

            for(int i=parent.size()-1; i>=0;i--){
                list.add(parent.get(parent.size()-1-i).val);
                if(!b){
                    if(parent.get(i).right!=null) current.add(parent.get(i).right);
                    if(parent.get(i).left!=null) current.add(parent.get(i).left);
                }else{
                    if(parent.get(i).left!=null) current.add(parent.get(i).left);
                    if(parent.get(i).right!=null) current.add(parent.get(i).right);
                }
            }//for
            b=!b;
            result.add(list);
            parent=current;
        }//while
        
        return result;
    }
}
