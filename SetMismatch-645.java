class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int result[] = new int[2];
        if(nums == null || nums.length < 1) return result;
        for(int i = 0 ; i < nums.length ; i++){
            int value = nums[i];
            if(value < 0) value *= -1;
            value -= 1;
            if(nums[value] < 0)
                result[0] = value + 1;
            else
                nums[value] *= -1;
        }   
            
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0){
                result[1] = i + 1;
                break;
            }
        }
        if(result[0] < 0) result[0] *= -1;
        return result;
    }
}
