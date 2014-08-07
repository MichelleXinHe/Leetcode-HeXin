//if all numbers are distinct-O(log(n))
//the more duplicates, the more tend to be O(n)
//duplicates exist: using the value of mid and start to discuss different cases
public class Solution {
    public boolean search(int[] a, int t) {
        int b=BS(a, t, 0, a.length-1);
        if(b==-1) return false;
        else return true;
    }
    
    public int BS(int[] a, int t, int s, int e){
        if(s>e) return -1;
        int mid=(s+e)/2;
        int mval=a[mid];
        
        if(mval==t) return mid;
         
        if(mval>a[s]){//left is in order
            if(t>=a[s]&&t<mval)
                return BS(a, t, s, mid-1);
            else
                return BS(a, t, mid+1, e);
        }
        else if(mval<a[s]){//right is in order
            if(t>mval&&t<=a[e]) return BS(a, t, mid+1, e);
            else return BS(a, t, s, mid-1);
        }else{//mval==a[s]
            if(mval!=a[e])//left is all duplicate
                return BS(a, t, mid+1, e);
            else{//no way to tell which side is in order
                int m=BS(a, t, s, mid-1);
                if(m!=-1) return m;
                else return BS(a, t, mid+1, e);
            }
        }
    }
}
