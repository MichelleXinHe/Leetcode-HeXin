//binary search
//when find an equality to x, do binary seach on both side
public class Solution {
    public int[] searchRange(int[] a, int x) {
        if(a==null) return new int[2];
        return helper(a, x, 0, a.length-1);
    }
    
    public int[] helper(int[] a, int x, int s, int e){
        if(s>e){
            int[] result=new int[2];
            result[0]=-1; result[1]=-1;
            return result;
        }
        int mid=(s+e)/2;
        int val=a[mid];
        if(val>x) return helper(a, x, s, mid-1);
        else if(val<x) return helper(a, x, mid+1, e);
        else{
            int[] result=new int[2];
            int[] left=helper(a, x, s, mid-1);
            int[] right=helper(a, x, mid+1, e);
            result[0]=(left[0]==-1)?mid:left[0];
            result[1]=(right[1]==-1)?mid:right[1];
            return result;
        }
    }
}
