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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return (l1==null)? l2:l1;
        ListNode head=(l1.val<l2.val)?l1:l2;
        if(head==l1)
            l1=l1.next;
        else
            l2=l2.next;
    
        ListNode r=head;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                r.next=l1;
                l1=l1.next;
            }else{
                r.next=l2;
                l2=l2.next;
            }
            r=r.next;
        }
        
        if(l1==null) r.next=l2;
        else r.next=l1;
        return head;
    }
}
