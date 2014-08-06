public class LRUCache {
    private int c;
    private int current=0;
    private MyLinkedList list;
    private HashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.c=capacity;
        list=new MyLinkedList();
        map=new HashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            list.remove(key);
            list.add(key);
            return map.get(key);
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            list.remove(key);
        }else{
            if(current<c){
                current++;
            }else{
                int k=list.removeFirst().val;
                map.remove(new Integer(k));
            }
        }
        list.add(key);
        map.put(key, value);
    }
}

class Node{
    Node prev, next;
    int val;
    
    public Node(int val){
        prev=null;
        next=null;
        this.val=val;
    }
    
    public void setNext(Node n){
        next=n;
    }
    
    public void setPrev(Node n){
        prev=n;
    }
    
    public boolean equals(Object o){
        if(!(o instanceof Node)) return false;
        Node n=(Node) o;
        if(n.val==this.val) return true;
        else return false;
    }
    
    public int hashCode(){
        return val;
    }
}

class MyLinkedList{
    Node head, tail;
    //need two maps to get store the next and prev node of each node
    HashMap<Node, Node> map;//prev
    HashMap<Node, Node> map2;//next
    public MyLinkedList(){
        map=new HashMap<Node, Node>();
        map2=new HashMap<Node, Node>();
        head=null;
        tail=null;
    }
    
    //append to the end of the list
    public void add(int n){
        Node d=new Node(n);
        if(head==null){
            head= d;
            tail=head;
            map.put(head, null);
            map2.put(head, null);
        }else{
            tail.setNext(d);
            d.setPrev(tail);
            map.put(d, tail);
            map2.put(tail, d);
            map2.put(d, null);
            tail=d;
        }
    }
    
    public Node removeFirst(){
        if(head==null) return null;
        else{
            Node n=head;
            map.remove(n);
            map2.remove(n);
            head=head.next;
            map.put(head, null);
            if(n.equals(tail)) tail=null;
            return n;
        }
        
    }
    
    public Node removeLast(){
        if(tail==head) return removeFirst();
        Node r=tail;
        Node prev=map.get(tail);
        prev.setNext(null);
        map.remove(tail);
        map2.remove(tail);
        map2.put(prev, null);
        tail=prev;
        return r;
    }
    
    public void remove(int n){
        Node node=new Node(n);
        if(!map.containsKey(node)) return;
        Node p=map.get(node);
        Node next=map2.get(node);
        //discussion here!!!!
        if(node.equals(head)){
            removeFirst();
        }else if(node.equals(tail)){
            removeLast();
        }else{
            map.remove(n);
            map2.remove(n);
            //p is not null here for sure
            //p is null-removeFirst
            p.setNext(next);
            //if(next!=null)
                next.setPrev(p);
            map.put(next, p);
            map2.put(p, next);
        }
    }
    
    public String toString(){
    	String s="";
    	Node n=head;
    	while(n!=null){
    		s+=n.val+" ";
    		n=n.next;
    	}
    	return s;
    }
}
