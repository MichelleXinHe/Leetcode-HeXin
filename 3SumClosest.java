//time complexity: O(n^2) space: O(1)
//use each of the element (except the last two) n[i] as the first one in the list
//then find the 2sum closest to the rest sum=t-n[i], compare each of these three sums with the current 
//closest one, the update the current closest value if necessary
//move the pointers in finding 2sum closest- similar to 2sum
public class Solution {
    public int threeSumClosest(int[] n, int t) {
        if(n==null||n.length<3) return -1;
        int len=n.length;
        Arrays.sort(n);
        int last=n[0]+1;
        int c=n[0]+n[1]+n[2];
        for(int i=0; i<len-2;i++){
            if(n[i]==last) continue;
            int nt=t-n[i];
            int p=i+1, q=len-1;
            while(p<q){
                int diff1=Math.abs(t-n[p]-n[q]-n[i]);
                int diff2=Math.abs(t-c);
                c=(diff1<diff2)?(n[i]+n[p]+n[q]):c;
                //need to correct use the inequality sign
                if(nt<n[p]+n[q]) q--;
                else p++;
            }
            last=n[i];
        }
        return c;
    }
}
