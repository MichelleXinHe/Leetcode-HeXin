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
    //recursive
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list= new ArrayList<List<Integer>>();
        if(root==null) return list;
        if(root.val==sum&&root.left==null&&root.right==null){
            List<Integer> l=new ArrayList<Integer>();
            l.add(root.val);
            list.add(l);
            return list;
        }
        
        List<List<Integer>> left=pathSum(root.left, sum-root.val);
        List<List<Integer>> right=pathSum(root.right, sum-root.val);
        if(left.size()>0){
            for(List<Integer> l:left){
                List<Integer> ll=new ArrayList<Integer>(l);
                ll.add(0, root.val);
                list.add(ll);
            }
        }
        if(right.size()>0){
            for(List<Integer> l:right){
                List<Integer> ll=new ArrayList<Integer>(l);
                ll.add(0, root.val);
                list.add(ll);
            }
        }
        return list;
        
    }
}
