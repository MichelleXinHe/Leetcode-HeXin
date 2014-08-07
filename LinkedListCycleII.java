/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null) return null;
        ListNode r1=head;
        ListNode r2=head;
        while(r1!=null&&r1.next!=null){
            r1=r1.next.next;
            r2=r2.next;
            if(r1==r2)
                break;
        }
        
        //no loop exists
        if(r1==null||r1.next==null)
            return null;
        
        r1=head;
        while(r1!=r2){
            r1=r1.next;
            r2=r2.next;
        }
        
        return r1;
    }
}
