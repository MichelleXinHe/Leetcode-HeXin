public class Solution {
    public int removeElement(int[] a, int elem) {
        int begin=0;
        for(int i=0; i<a.length; i++){
            if(a[i]!=elem)
                a[begin++]=a[i];
        }
        return begin;
    }
}
