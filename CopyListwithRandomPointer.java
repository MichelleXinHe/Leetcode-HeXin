/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
//http://fisherlei.blogspot.com/2013/11/leetcode-copy-list-with-random-pointer.html

public class CopyListwithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null) return null;
        RandomListNode n=head;
        while(n!=null){
            RandomListNode m=new RandomListNode(n.label);
            RandomListNode next=n.next;
            n.next=m;
            m.next=next;
            n=next;
        }
        
        n=head;
        while(n!=null){
            if(n.random!=null)
                n.next.random=n.random.next;
            n=n.next.next;
        }
        
        RandomListNode m=head;
        RandomListNode h=head.next;
        n=h;
        //n.next!=null
        while(m!=null&&n.next!=null){
            m.next=n.next;
            m=m.next;
            n.next=m.next;
            n=n.next;
        }
        //the tail of the original link still connect with the tail of the new list
        m.next=null;
        return h;
    }
}
