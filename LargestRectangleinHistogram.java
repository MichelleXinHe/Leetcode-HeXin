//time: O(n) 
//brute force: for each rectangle, use itself as center, look towards its left and right, until meet
//elements that are smaller than itself, than calculate the area

//Time: O(n)
//For every bar 'x', we calculate the area with 'x' as the smallest bar in the rectangle.
//basic idea is the same as the brute force method:
//We need to know index of the first smaller (smaller than 'x') bar on left of 'x' and index of first smaller bar on right of 'x'. Let us call these indexes as 'left index' and 'right index' respectively.
//use a stack to record the 'left index' of the current bar 'x'
//we traverse all bars from left to right, maintain a stack of bars. every bar is pushed to stack once. a bar is popped from stack when a bar of smaller heigh is seen. when a bar is popped, we calculate the area with the popped bar as smallest bar. 
//the current index 'i' tells us the 'right index' and the index of the previous item in the stack is the 'left index'

//http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
public class Solution {
    //brute force: TLE
    public int largestRectangleArea1(int[] height) {
       if(height==null||height.length==0) return 0;
       int n=height.length;
       int[] left=new int[n];
       int[] right=new int[n];
       
       //left[0]=-1;
       for(int i=1; i<n; i++){
           int start=i-1;
           while(start>=0&&height[start]>=height[i]) start--;
           if(start==-1&&height[0]>=height[i]) left[i]=0;
           else left[i]=start+1;
       }
       
       right[n-1]=n-1;
       for(int i=0; i<n-1; i++){
           int start=i+1;
           while(start<n&&height[start]>=height[i]) start++;
           if(start==n&&height[n-1]>=height[i]) right[i]=n-1;
           else right[i]=start-1;
       }
       
       int max=0;
       for(int i=0; i<n; i++){
           int area=height[i]*(right[i]-left[i]+1);
           max=Math.max(max, area);
       }
       return max;
    }
    
    //calculate the area that each bar as the shortest bar in that rectangle
    //so only need to find the first left bar that is <= this bar and so is the first right bar
    public int largestRectangleArea(int[] height) {
        if(height==null||height.length==0) return 0;
        //the heights of all bars in stack are non-decreasing order
        //so for each bar on top, the bar under it is the left index
        Stack<Integer> s=new Stack<Integer>();
        int i=0, n=height.length, max=0;
        while(i<n){
            if(s.size()==0||height[i]>=height[s.peek()]){
                s.push(i);
                i++;//only here need to increase i
            }else{//this process will continue until all the bars in the stack that is >i are calculated, than i will be pushed into
            //the stack
                //now the right index is found for this bar
                //pop it out, has no influence to bars after i
                int current=s.pop();
                //s.peek() is the left index of the bar shorter than current
                int area=height[current]*((s.size()==0)?i:i-s.peek()-1);
                max=Math.max(max, area);
            }
        }
        
        //dont forget the rest bars in the stack
        while(s.size()>0){
            int current=s.pop();
            int area=height[current]*((s.size()==0)?i:i-s.peek()-1);
            max=Math.max(max, area);        
        }
        return max;
    }        
}
