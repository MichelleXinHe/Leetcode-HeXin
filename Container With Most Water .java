public class Solution {
    public int maxArea(int[] height) {
        int area=0;
        int start=0, end=height.length-1;
        while(start<end){
            int temp=Math.min(height[start], height[end])*(end-start);
            area=Math.max(temp, area);
            if(height[start]<height[end]) start++;
            else end--;
        }
        return area;
    }
}
