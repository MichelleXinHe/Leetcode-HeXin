public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        if(s.length()<2) return s.length();
        boolean[] flag=new boolean[256];
        int max=1, start=0, end=0;
        while(end<s.length()){
            char c=s.charAt(end);
            if(!flag[c]){
                flag[c]=true;
                end++;
            }else{
                max=Math.max(max, end-start);
                //this line should before updating start pointer
                int lastEnd=start-1;
                start=end-1;
                while(start>=0&&s.charAt(start)!=c) start--;
                start++;
                //from this point, all the char between lastEnd and i should be cleared
                int i=start-2;
                while(i>lastEnd&&i>=0){
                    flag[s.charAt(i)]=false;
                    i--;
                }
                //update the end here! since didnot clear the char of end in boolean array in last step
                end++;
            }
        }
        //dont forget the last value!!!
        max=Math.max(max, end-start);
        return max;
    }
}
