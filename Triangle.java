public class Solution {
    //bottom up DP solution
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        List<Integer> past=triangle.get(n-1);
        for(int i=n-2; i>=0; i--){
            List<Integer> current=triangle.get(i);
            for(int j=0; j<current.size(); j++){
                int val=current.get(j);
                int left=past.get(j);
                int right=past.get(j+1);
                current.set(j, val+Math.min(left, right));
            }
            past=current;
        }
        return past.get(0);
    }
}
