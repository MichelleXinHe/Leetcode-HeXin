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
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode h=head;
        ListNode r=head.next;
        while(r!=null){
            ListNode t=r.next;
            ListNode prev=null;
            while(r!=head){
                if(r.val<=head.val){
                    r.next=head;
                    if(prev!=null) prev.next=r;
                    else h=r;
                    while(head.next!=r) head=head.next;
                    head.next=t;
                    //break the inner loop after this node is in the correct position
                    //the inner loop condition will not be meet in this case- so break
                    break;
                }else{
                    prev=head;
                    head=head.next;
                }
            }
            head=h;
            r=t;
        }
        return h;
    }
}
