//O(n) time complexity
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0||prices.length==1) return 0;
        int min=prices[0];
        int profit=0;
        //always use the current price to subtract the min value before this price
        for(int i=1; i<prices.length;i++){
            min=Math.min(min, prices[i]);
            profit=Math.max(profit, prices[i]-min);
        }
        
        return profit;
    }
}
