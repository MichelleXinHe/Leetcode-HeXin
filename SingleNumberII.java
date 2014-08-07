// bit manipulation
// if all the number appear three times, sum of ith bit of all number will be a dividable by 3
// so the ith bit of the unknow number is x%3
public class Solution {
    public int singleNumber(int[] A) {
        int[] c=new int[32];
        int r=0;
        for(int i=0;i<32;i++){
            for(int j=0;j<A.length;j++){
                if(((A[j]>>i)&1)==1){//if ith bit is one-1=00000...0001
                    c[i]++;
                }
            }
            r|=(c[i]%3)<<i;
        }
        return r;
    }
}
