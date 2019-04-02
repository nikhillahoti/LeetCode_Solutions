class Solution {
    
    int leftRange = Integer.MAX_VALUE, rightRange = Integer.MIN_VALUE;
    
    public int[] searchRange(int[] nums, int target) {
        
        if(nums != null && nums.length >= 1)
            binarySearch(0, nums.length - 1, target, nums);
        
        int result[] = new int[2];
        result[0] = leftRange == Integer.MAX_VALUE ? -1 : leftRange;
        result[1] = rightRange == Integer.MIN_VALUE ? -1 : rightRange;
        return result;
    }
    
    public void binarySearch(int low, int high, int target, int [] nums){
        int mid = 0;
                
        while(low <= high){
            mid = (low + high) / 2;
            if(nums[mid] == target){
                leftRange = Math.min(leftRange, mid);
                rightRange = Math.max(rightRange, mid);
                binarySearch(low, mid - 1, target, nums);            
                binarySearch(mid + 1, high, target, nums);            
                break;
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
    }
    
}
