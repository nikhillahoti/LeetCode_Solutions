// Problem: 484
class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int dominantElem = nums[0];
        int count = 1;
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i] == dominantElem){
                count++;
                continue;
            }
            else {
                count--;
                if(count == 0){
                    dominantElem = nums[i+1];
                    count = 1;
                    i++;
                }
            }
        }
        return dominantElem;
    }
}


