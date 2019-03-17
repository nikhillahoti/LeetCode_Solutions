class Solution {
    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length < 3) return 0;
        
        int count = 0;
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(nums[i] == 0) continue;
            for(int k = nums.length - 1 ; k > i + 1 ; k--){
                for(int j = i + 1 ; j < nums.length - 1 ; j++){
                    if(nums[i] + nums[j] > nums[k]){
                        count += (k - j);
                        break;
                    }
                }   
            }
        }      
        return count;
    }
}
