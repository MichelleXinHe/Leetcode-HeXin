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
//there is another java method at the end of this page-with one pass
public class Solution {
    //should revise this method, even though pass the test
    //could combine the process to find the head and tail of the reversed list in one pass
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if(head==null||n==1) return head;
        ListNode r=head;
        for(int i=0; i<n-1; i++) r=r.next;
        ListNode h=r.next;
        r.next=null;//break the original link-dead loop otherwise
        if(m==1){
            head=reverse(head);
            r=head;
        }else{
            r=head;
            ListNode prev=null;
            for(int i=0; i<m-1;i++){
                prev=r;
                r=r.next;
            }
            prev.next=null;
            r=reverse(r);
            prev.next=r;
        }
        //connect the tail of the reversed list to node h
        while(r.next!=null) r=r.next;
        r.next=h;
        return head;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||n==1) return head;
        ListNode extra=new ListNode(0);
        extra.next=head;
        head=extra;
        ListNode prev=null;
        for(int i=0; i<m; i++){
            prev=extra;
            extra=extra.next;
        }
        prev.next=null;
        ListNode h=extra;
        for(int i=0; i<n-m; i++)
            extra=extra.next;
        ListNode h2=extra.next;
        extra.next=null;
        h=reverse(h);
        prev.next=h;
        while(h.next!=null)
            h=h.next;
        h.next=h2;
        
        return head.next;
    }
    //recursive method
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode h=reverse(head.next);
        head.next=null;
        ListNode r=h;
        while(r.next!=null) r=r.next;
        r.next=head;
        return h;
    }
    
    //this is one pass method
    public ListNode reverseBetween3(ListNode head, int m, int n) {
        if(head==null || head.next==null) return head;

        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode p = newhead;
        int k = 1;

        while(k++<m) p = p.next;

        ListNode p1 = p.next;
        ListNode temp = p1;

        while(m++<n) {
            temp = p1.next;
            p1.next = temp.next;
            temp.next = p.next;
            p.next = temp;
        }

        return newhead.next;
    }
}
