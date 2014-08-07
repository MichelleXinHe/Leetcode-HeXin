/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connectRecursion(TreeLinkNode root) {
        if(root==null) return;
        //need to check if the left and right are null, otherwise the next link on null value!!!
        if(root.left!=null)
        root.left.next=root.right;
        if(root.right!=null&&root.next!=null)
            root.right.next=root.next.left;
        connect(root.left);
        connect(root.right);
    }
    
    //this is the iterative method-constant space
    public void connect(TreeLinkNode root){
        if(root==null) return;
        //head pointer: always along the left most branch of the binary tree
        //level pointer: go through all the nodes on each level(start from each head pointer)
        TreeLinkNode head=root;
        TreeLinkNode level=head;
        while(level!=null){
            //create connection for both children of the current level node
            if(level.left!=null) level.left.next=level.right;
            if(level.right!=null&&level.next!=null) level.right.next=level.next.left;
            
            //if this level node is not the end of this list, continue to the next node on the same level
            if(level.next!=null) level=level.next;
            //start a new level
            else{
                head=head.left;
                level=head;
            }
        }
    }
}
