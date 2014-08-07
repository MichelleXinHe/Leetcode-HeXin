/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        
        ListNode r1=head;
        ListNode r2=head;
        ListNode prev=null;
        while(r1!=null&&r1.next!=null){
            r1=r1.next.next;
            prev=r2;
            r2=r2.next;
        }
        //dont forget to break the link at the end of the first half
        prev.next=null;
        TreeNode root=new TreeNode(r2.val);
        r2=r2.next;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(r2);
        return root;
    }
}
