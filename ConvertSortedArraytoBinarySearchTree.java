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
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0) return null;
        return BST(num, 0, num.length-1);
    }
    
    public TreeNode BST(int[] num, int s, int e){
        if(s>e||s<0||e>=num.length) return null;
        
        int mid=(s+e)/2;
        TreeNode root=new TreeNode(num[mid]);
        root.left=BST(num, s, mid-1);
        root.right=BST(num, mid+1, e);
        return root;
    }
}
