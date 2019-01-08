
// Problem No. 162
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 1) return -1;
        if(nums.length < 2) return 0;
        
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        
        int counter = nums.length - 1;
        for(int i = 1 ; i < counter ; i++){
            if(nums[i - 1] < nums[i] && nums[i+1] < nums[i])
                return i;
        }
        return -1;
    }
}
