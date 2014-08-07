/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
 //bottom up DP
 //increment i, add node val=i to all existing result
 //1. new node can always be the root of all the existing results, and the existing results are the left tree of this new root
 //2. new node can be part of the right tree of the existing results, can from the first right kid to be the right most leaf
 //note: each time need to copy the original tree, and store the new tree to the result
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> result=new ArrayList<TreeNode>();
        if(n<0) return result;
        if(n==0) result.add(null);
        if(n>=1) result.add(new TreeNode(1));
        for(int i=2; i<=n; i++){
            ArrayList<TreeNode> temp=new ArrayList<TreeNode>();
            for(TreeNode t:result){
                TreeNode m=new TreeNode(i);
                m.left=t;
                temp.add(m);
                
                TreeNode s=t;
                while(s!=null){
                    TreeNode r=insert(t, s, s.right, i);
                    temp.add(r);
                    s=s.right;
                }
            }
            result=temp;
        }
        return result;
    }
    
    public TreeNode insert(TreeNode t, TreeNode s, TreeNode sr, int i){
        //create the shapge of the new tree based on the previous result
        TreeNode n=new TreeNode(i);
        s.right=n;
        n.left=sr;
        TreeNode root=copy(t);
        //remeber to break the change here, dont change the existing tree here!!!
        s.right=sr;
        return root;
    }
    
    public TreeNode copy(TreeNode r){
        if(r==null) return null;
        
        TreeNode root=new TreeNode(r.val);
        root.left=copy(r.left);
        root.right=copy(r.right);
        return root;
    }
    
}
