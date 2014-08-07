/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
        TreeLinkNode head=root;
        while(head!=null){
            TreeLinkNode n=nextNode(head);//n has at least one kid
            TreeLinkNode p=n;
            while(n!=null){
                TreeLinkNode m=null;
                if(n.left!=null&&n.right!=null){
                    n.left.next=n.right;
                    m=n.right;
                }else
                    m=(n.left==null)?n.right:n.left;
                    
                n=nextNode(n.next);
                if(n!=null){
                    if(n.left!=null) m.next=n.left;
                    else m.next=n.right;
                }
            }//inner-while
            if(p!=null){
                head=(p.left!=null)?p.left:p.right;
            }else head=null;
        }//outer-while
    }
    
    public TreeLinkNode nextNode(TreeLinkNode head){
        if(head==null) return null;
        if(head.left!=null||head.right!=null) return head;
        else return nextNode(head.next);
    }
}
