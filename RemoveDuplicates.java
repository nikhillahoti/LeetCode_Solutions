
// Problem No. 80
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 1) return 0;
        int pivot = 1;
        int last = nums[0];
        int i = 1;
        while(i < nums.length)
        {
            if(last == nums[i]){
                nums[pivot++] = nums[i];
            }
            while(i < nums.length && nums[i] == last){
                i++;
            }
            if(i < nums.length && last != nums[i]){
                nums[pivot++] = nums[i];
                last = nums[i++];
                continue;
            }
            break;
        }
        return pivot;
    }
}
