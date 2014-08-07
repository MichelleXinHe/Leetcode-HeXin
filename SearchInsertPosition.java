public class Solution {
    public int searchInsert(int[] a, int target) {
        return BS(a, target, 0, a.length-1);
    }
    
    public int BS(int[] a, int t, int s, int e){
        if(s>e||s<0||e<0||s>=a.length||e>=a.length){
            return s;
        }
        int mid=(s+e)/2;
        if(a[mid]==t) return mid;
        else if(a[mid]>t) return BS(a, t, s, mid-1);
        else return BS(a, t, mid+1, e);
    }
}
