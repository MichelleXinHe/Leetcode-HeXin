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
    public ListNode rotateRight(ListNode head, int n) {
        if(n==0||head==null||head.next==null) return head;
        int size=1;
        ListNode r=head;
        while(r.next!=null){
            size++;
            r=r.next;
        }
        r.next=head;
        n=size-n%size;
        ListNode prev=null;
        for(int i=0;i<n;i++){
            prev=head;
            head=head.next;
        }
        prev.next=null;
        return head;
    }
}
