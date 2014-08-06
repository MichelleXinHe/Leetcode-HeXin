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
 
 //merge sort on a singly linkedlist
public class MergeSort {
    public ListNode sortList(ListNode head) {
        //base case-on a recursive method
        if(head==null||head.next==null) return head;
        
        //divide
        ListNode r1=head;
        ListNode r2=head;
        ListNode pre=null;
        while(r1!=null&&r1.next!=null){
            r1=r1.next.next;
            pre=r2;
            r2=r2.next;
        }
        //need to break the link at the end of the first half!!!!
        pre.next=null;
        ListNode h1=sortList(head);
        ListNode h2=sortList(r2);
        //conquer
        ListNode newHead=merge(h1, h2);
        return newHead;
    }
    
    public ListNode merge(ListNode h1, ListNode h2){
        if(h1==null||h2==null) return (h1==null)?h2:h1;
        ListNode head=(h1.val>h2.val)?h2:h1;
        ListNode r=head;
        if(head==h1) h1=h1.next;
        else h2=h2.next;
        while(h1!=null&&h2!=null){
            if(h1.val<h2.val){
                r.next=h1;
                h1=h1.next;
            }else{
                r.next=h2;
                h2=h2.next;
            }
            r=r.next;
        }
        r.next=(h1==null)?h2:h1;
        return head;
    }
}
