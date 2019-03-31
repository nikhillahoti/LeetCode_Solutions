class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 1) return false;
        
        Map<Integer, Integer> remainder = new HashMap<>();
        int sum = 0;
        remainder.put(0, -1);
        for(int i = 0 ; i < nums.length ; i++){
            sum += nums[i];
            
            if(k != 0)
                sum %= k;
            
            Integer prev = remainder.get(sum);
            if(prev == null)
                remainder.put(sum, i);    
            else 
            {
                if(i - prev > 1) return true;
            }                
        }
        return false;
    }
}
