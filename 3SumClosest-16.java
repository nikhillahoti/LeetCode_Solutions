// Problem No. 16

class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        
        Arrays.sort(nums);
        
        int min = nums[0] + nums[1] + nums[nums.length - 1];
        int counter = nums.length - 2;
        for(int i = 0 ; i < counter ; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
            
                if(Math.abs(sum - target) < Math.abs(min - target)) {
                    min = sum;
                }
                
                if(sum < target)
                    start++;
                else 
                    end--;
                
            }
        }
        return min;
    }    
}
