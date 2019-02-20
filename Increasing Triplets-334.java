
// Problem No. 334
class Solution {
    public boolean increasingTriplet(int[] nums) {
       
        if(nums == null || nums.length < 3) return false;
       
        int max[] = new int[nums.length];
        max[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2 ; i > -1 ; --i){
            if(nums[i] > max[i+1]) max[i] = nums[i];
            else max[i] = max[i+1];
        }
       
        int low = nums[0];
        for(int i = 1 ; i < nums.length - 1 ; i++){
            if(nums[i] > low && nums[i] < max[i+1]) return true;
            if(low > nums[i]) low = nums[i];
        }
        return false;       
    }
}
