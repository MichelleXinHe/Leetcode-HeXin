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
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists==null||lists.size()==0) return null;
        while(lists.size()>1){
            int n=lists.size();
            //this temp should be inside of the while loop
            List<ListNode> temp=new ArrayList<ListNode>();
            //i should be i+2 here!!!
            for(int i=0; i<n-1; i+=2)
                temp.add(merge(lists.get(i), lists.get(i+1)));
            if(n%2==1) temp.add(lists.get(n-1));
            lists=temp;
        }
        return lists.get(0);
    }
    
    public ListNode merge(ListNode r1, ListNode r2){
        if(r1==null||r2==null) return (r1==null)?r2:r1;
        ListNode head=null;
        if(r1.val<r2.val){
            head=r1;
            r1=r1.next;
        }else{
            head=r2;
            r2=r2.next;
        }
        
        ListNode run=head;
        while(r1!=null&&r2!=null){
            if(r1.val<r2.val){
                run.next=r1;
                r1=r1.next;
            }else{
                run.next=r2;
                r2=r2.next;
            }
            run=run.next;
        }
        run.next=(r1==null)?r2:r1;
        return head;
    }
}
