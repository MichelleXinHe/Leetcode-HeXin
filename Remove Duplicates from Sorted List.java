/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null)
            return head;
        
        ListNode r= head;
        ListNode p=head.next;
        while(p!=null){
            if(p.val==r.val){
                r.next=p.next;
            }else{
                r=r.next;
            }
            p=p.next;
        }
        return head;
    }
}
