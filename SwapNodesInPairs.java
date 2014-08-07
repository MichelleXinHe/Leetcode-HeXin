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
    public ListNode swapPairs(ListNode head) {
       if(head==null||head.next==null) return head;
       ListNode h=head.next;
       ListNode last=null;
       while(head!=null&&head.next!=null){
           ListNode n=head.next;
           head.next=n.next;
           n.next=head;
           if(last!=null) last.next=n;
           last=head;
           head=head.next;
       }
       
       return h;
    }
}
