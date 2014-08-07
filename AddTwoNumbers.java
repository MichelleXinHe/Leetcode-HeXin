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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null||l2==null) return (l1==null)?l2:l1;
        return add(l1, l2, 0);
    }
    
    public ListNode add(ListNode l1, ListNode l2, int carry){
        if(l1==null&&l2==null&&carry==0) return null;
        
        int sum=carry;
        if(l1!=null)
            sum+=l1.val;
            
        if(l2!=null)
            sum+=l2.val;
        
        int val=sum%10;
        int c=sum/10;
        ListNode n=new ListNode(val);
        n.next=add((l1==null)?null:l1.next, (l2==null)?null:l2.next,c);
        return n;
    }
}
