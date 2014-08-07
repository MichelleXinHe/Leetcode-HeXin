public class Solution {
    public int sqrt(int x) {
        if(x<=0) return 0;
        //if(x<=3) return 1;
        int min=1, max=x/2;
        int sq=1;
        while(min<=max){
            int mid=(min+max)/2;
            if(mid<x/mid){
                sq=mid;
                min=mid+1;
            }else if(mid>x/mid) max=mid-1;
            else return mid;
        }
        return sq;
    }
}
