
// Problem No. 448
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> output = new ArrayList<>();
        
        if(nums == null || nums.length < 1) return output; 
        
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++)
            hash.add(nums[i]);
        
        int counter = nums.length + 1;
        for(int i = 1 ; i < counter ; i++)
            if(!hash.contains(i))
                output.add(i);        
        
        return output;
    }
}
