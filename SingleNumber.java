public class Solution {
    // the properties of XOR
    // XOR is commutative and associative (so the order in which it's done is irrelevant).
    // a number XORed with itself will always be zero.
    // zero XORed with a number will be that number.
    public int singleNumber(int[] A) {
        int n=0;
        for(int i:A)
            n= n^i;
        return n;
    }
}
