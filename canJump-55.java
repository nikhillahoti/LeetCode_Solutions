class Solution {
    public boolean canJump(int[] nums) {
        
        if(nums == null || nums.length < 1) return true;
        
        int dp[] = new int[nums.length];
        dp[nums.length - 1] = 1;
        
        for(int i = nums.length - 2 ; i > -1 ; i--){
            int steps = nums[i];
            int endPoint = Math.min(nums.length - 1, i + steps);
            for(int j = i + 1 ; j <= endPoint ; j++){
                if(dp[j] == 1){
                    dp[i] = 1;
                    break;
                }
            }
        }
        
        return dp[0] == 1 ? true : false;
    }
}
