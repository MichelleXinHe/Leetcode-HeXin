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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null|k<=1) return head;
        ListNode dumb=new ListNode(-1);
        dumb.next=head;
        ListNode h=dumb.next, t=h, p=dumb;
        while(h!=null){
            for(int i=0; i<k-1;i++){
                if(t!=null) t=t.next;
            }
            
            if(t==null){
                p.next=h;
                break;
            }else{
                ListNode temp=t.next;
                t.next=null;
                p.next=reverse(h);
                p=h;
                h=temp;
                t=h;
            }
        }
        return dumb.next; 
        
    }
    
    //iterative method
    public ListNode reverse(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode r=head.next;
        head.next=null;
        ListNode r1=(r==null)?null:r.next;
        r.next=head;
        while(r1!=null){
            ListNode r2=r1.next;
            r1.next=r;
            r=r1;
            r1=r2;
        }
        return r;
    }
}
