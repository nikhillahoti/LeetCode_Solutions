class Solution {
    public int pivotIndex(int[] nums) {
        
        if(nums == null || nums.length < 1) return -1;
        
        int rightSum = 0;
        for(int i = nums.length - 1 ; i > 0 ; i--)
            rightSum += nums[i];
        
        int leftSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(leftSum == rightSum) return i;
            leftSum += nums[i];
            if(i + 1 < nums.length)
                rightSum -= nums[i+1];
        }
        return -1;
    }
}
