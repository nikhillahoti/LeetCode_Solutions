
// Problem No. 740
class Solution {
    public int deleteAndEarn(int[] nums) {
       
        if(nums == null || nums.length < 1) return 0;
       
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(count.containsKey(nums[i]))
                count.put(nums[i], count.get(nums[i]) + 1);
            else
                count.put(nums[i], 1);
        }
       
        int[] result = new int[count.size()];
        int i = 0;
        for(Integer key: count.keySet())
            result[i++] = key;
       
        Arrays.sort(result);
        int dp[] = new int[count.size()];
        dp[0] = count.get(result[0]) * result[0];
        for( i = 1 ; i < result.length ; i++){
            if(result[i] == result[i-1] + 1) {
                int prev = 0;
                if(i - 2 >= 0) prev = dp[i-2];

                dp[i] = Math.max(dp[i-1], result[i] * count.get(result[i]) + prev);   
            }
            else {
                dp[i] = dp[i-1] + result[i] * count.get(result[i]);
            }    
        } 
       
        return dp[result.length - 1];
    }
}
