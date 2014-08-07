//at most twice: 1, 2
//f[i]-the largest profits from 0 to i
//g[i]-the largest profits from i to n-1
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<2) return 0;
        int n=prices.length;
        int[] f=new int[n];
        int[] g=new int[n];
        
        int currentMin=prices[0];
        for(int i=1; i<n;i++){
            currentMin=Math.min(currentMin, prices[i]);
            f[i]=Math.max(f[i-1], prices[i]-currentMin);
        }
        
        int currentMax=prices[n-1];
        for(int i=n-2; i>=0; i--){
            currentMax=Math.max(currentMax, prices[i]);
            g[i]=Math.max(g[i+1], currentMax-prices[i]);
        }
        
        int max=0;
        for(int i=0; i<n; i++) max=Math.max(max, f[i]+g[i]);
        return max;
    }
}
