class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost == null || cost.length < 1) return 0;
        
	// So the idea is that we can start from the first of the second step and every step after that, 
	// we check if it easy to reach here from i - 1 or i - 2

        int dp[] = new int[cost.length];
        dp[0] = cost[0]; dp[1] = cost[1];
        for(int i = 2 ; i < cost.length ; ++i)
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];

	// Finally we check which step is easier to get the final or the second last because we can reach the second last step 
	// and pay the price on that step and reach the top or directly reach the second last step
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
