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
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null) return head;
        //fh and sh are the heads of the two lists
        //r1 and r2 are the tails of the two lists
        ListNode fh=null, sh=null, r1=null, r2=null;
        while(head!=null){
            ListNode temp=head.next;
            if(head.val<x){
                if(fh==null){
                    fh=head;
                    r1=head;
                }else{
                    r1.next=head;
                    //dont forget to move the pointer here
                    r1=r1.next;
                }
            }else{
                if(sh==null){
                    sh=head;
                    r2=head;
                }else{
                    r2.next=head;
                    //dont forget to move the pointer here
                    r2=r2.next;
                }
            }
            head.next=null;
            head=temp;
        }
        
        if(fh==null) return sh;
        r1.next=sh;
        return fh;
    }
}
