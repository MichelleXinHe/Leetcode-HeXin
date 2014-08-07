public class Solution {
    public int search(int[] A, int target) {
        return BS(A, 0, A.length-1, target);
    }
    
    public int BS(int[] a, int s, int e, int t){
        if(s>e||s>=a.length||e<0) return -1;
        int mid=(s+e)/2;
        int mval=a[mid];
        if(mval==t) return mid;
        else if(mval<t){
            if(a[s]<mval){//left is in order
                return BS(a, mid+1, e, t);
            }else{//right is in order
                if(t<=a[e]) return BS(a, mid+1, e, t);
                else return BS(a, s, mid-1, t);
            }
        }else{//mval>t
            if(mval<a[e]){//right is in order
                return BS(a, s, mid-1, t);
            }else{//left in order
                if(t>=a[s]) return BS(a, s, mid-1, t);
                else return BS(a, mid+1, e, t);
            }
        }
    }
}
