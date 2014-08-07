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
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head==null||head.next==null) return;
        ListNode r1=head;
        ListNode r2=head;
        ListNode prev=null;
        while(r1!=null&&r1.next!=null){
            r1=r1.next.next;
            prev=r2;
            r2=r2.next;
        }
        
        if(r1!=null){
            prev=r2;
            r2=r2.next;
        }
        //break the link at the end of the first half
        prev.next=null;
        
        r2=reverse(r2);
        r1=head;
        while(r2!=null){
            ListNode temp1=r1.next;
            ListNode temp2=r2.next;
            r1.next=r2;
            r2.next=temp1;
            r1=temp1;
            r2=temp2;
        }
    }
    
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode r=head.next;
        head.next=null;
        ListNode h=null;
        while(r!=null){
            ListNode temp=r.next;
            if(temp==null) h=r;
            r.next=head;
            head=r;
            r=temp;
        }
        return h;
    }
}
