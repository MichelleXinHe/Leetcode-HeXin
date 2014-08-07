/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //morris inorder traverse-find out two swapped nodes
public class Solution {
    //only exchange the value of the two nodes
    //no need to store their parents 
    public void recoverTree(TreeNode root) {
        if(root==null) return;
        TreeNode current=root, prev=null, p1=null, p2=null;
        while(current!=null){
            //analysis:  
            //http://yucoding.blogspot.com/2013/03/leetcode-question-75-recover-binary.html
            //be careful on assigning values to pointers
            if(prev!=null&&prev.val>current.val){
                if(p1==null){
                    p1=current;
                    p2=prev;
                }else p1=current;
            }
            
            if(current.left==null){
                prev=current;
                current=current.right;
            }else{
                TreeNode left=current.left;
                TreeNode temp=left;
                while(temp.right!=null&&temp.right!=current) temp=temp.right;
                if(temp.right==null){
                    temp.right=current;
                    current=left;
                }else{
                    temp.right=null;
                    prev=current;
                    current=current.right;
                }
            }
        }
        
        if(p1!=null&&p2!=null){
            int temp=p1.val;
            p1.val=p2.val;
            p2.val=temp;
        }
    }
}
