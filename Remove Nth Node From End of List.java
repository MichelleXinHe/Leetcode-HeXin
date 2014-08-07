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
 // different from the one on cc
 // return the head of the new list- maybe the head is the node removed
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0||head==null) return head;
        ListNode r1=head;
        for(int i=1; i<n;i++){
            //check if n>=list length
            //it ensures as long as it does not return from the for loop, r1 is always not null
            if(r1!=null&&r1.next!=null)
                r1=r1.next;
            else 
                return head;
        }
        //if r1 is at the end of the list, remove the current head
        if(r1.next==null) return head.next;
        ListNode r2=head;
        ListNode prev=null;
        while(r1.next!=null){
            r1=r1.next;
            prev=r2;
            r2=r2.next;
        }
        prev.next=r2.next;
        return head;
    }
}
