class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums == null || nums.length < 1) return;
        
        int start = 0, index = 0;
        while(index < nums.length){
            if(nums[index] != 0)
                nums[start++] = nums[index];
            index++;
        }
        while(start < nums.length)
            nums[start++] = 0;
    }
}
