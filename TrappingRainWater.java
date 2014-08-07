//an element can hold some water on top, only if the min edge on its both left and right are larger than this element
public class Solution {
    public int trap(int[] a) {
        int n=a.length;
        //check if the array length
        if(n==0) return 0;
        int[] left=new int[n];
        int[] right=new int[n];
        
        int max_left=0;
        for(int i=0; i<n; i++){
            left[i]=max_left;
            max_left=Math.max(max_left, a[i]);
        }
        
        int max_right=0;
        for(int i=n-1; i>=0; i--){
            right[i]=max_right;
            max_right=Math.max(max_right, a[i]);
        }
        
        int sum=0;
        for(int i=0; i<n; i++){
            int diff=Math.min(left[i], right[i]);
            if(diff>a[i]) sum+=(diff-a[i]);
        }
        
        return sum;
    }
}
