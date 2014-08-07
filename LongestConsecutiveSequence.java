//if sorting algorithm is allowed, worst case O(nlogn)
public class Solution {
    //with hash set, scan the whole array twice
    public int longestConsecutive(int[] num) {
        if(num==null||num.length==0) return 0;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:num) set.add(i);
        int maxLen=1;
        for(int i:num){
            if(!set.contains(i)) continue;
            int length=1;
            int n=i-1;
            while(set.contains(n)){
                set.remove(new Integer(n));
                n--;
                length++;
            }
            
            n=i+1;
            while(set.contains(n)){
                set.remove(new Integer(n));
                n++;
                length++;
            }
            
            maxLen=Math.max(maxLen, length);
        }
        return maxLen;
    }
}
