
// Problem No. 714
class Solution {
    public int maxProfit(int[] prices, int fee) {
        
        if(prices == null || prices.length < 1) return 0;
        
        int []dp = new int[prices.length + 1];
        Arrays.fill(dp, 0);
        
        for(int i = 1 ; i < prices.length ; i++){
            for(int j = 1 ; j <= i ; j++){
                dp[i + 1] = Math.max(prices[i] - prices[j-1] + dp[j-1] - fee, dp[i+1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        
        return dp[prices.length];
    }
}
