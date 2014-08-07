public class Solution {
    public int maxSubArray(int[] a) {
        if(a==null||a.length<1) return 0;
        int max=a[0], current=a[0];
        for(int i=1; i<a.length; i++){
            current=Math.max(current+a[i], a[i]);
            max=Math.max(current, max);
        }
        return max;
    }
}
