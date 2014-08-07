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
 //O(n) time complexity
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode r1=head;
        ListNode r2=head;
        while(r1!=null&&r1.next!=null){
            r1=r1.next.next;
            r2=r2.next;
            if(r1==r2)
                return true;
        }
        return false;
    }
}
