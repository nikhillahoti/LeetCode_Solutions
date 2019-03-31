public int numSubarrayProductLessThanK(int[] nums, int k) {

        if(nums == null || nums.length < 1) return 0;
                
        int cnt = 0, prod = 1;
        for(int right = 0, left = 0 ; right < nums.length ; right++)
        {
            prod *= nums[right];
            while(prod >= k && left <= right){
                prod /= nums[left++];
            }
            cnt += right - left +  1;
        }
        return cnt;
    }
    
