//Each element in the array represents your maximum jump length at that position.
//O(n) time complexity! very elegant code from Mike3
public class Solution {
    public boolean canJump(int[] a) {
        int canReach=0;//this is the furthest index we can reach
        for(int i=0; i<a.length&&i<=canReach; i++){
            if(i+a[i]>canReach) canReach=i+a[i];
            if(canReach>=a.length-1) return true;
        }
        return (canReach>=a.length-1);
    }
}
