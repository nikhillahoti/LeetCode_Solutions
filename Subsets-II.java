
// Problem No. 90
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> output1 = new ArrayList<>();
        if(nums == null || nums.length < 1) return output1;
        
        Arrays.sort(nums);
        
        permutate(new ArrayList<Integer>(), nums, 0);
        output1 = new ArrayList<>(output);
        return output1;
    }
    
    Set<List<Integer>> output = new HashSet<>();
    
    public void permutate(List<Integer> tempArr, int [] nums, int startIndex){
        output.add(new ArrayList<>(tempArr));
        
        if(startIndex >= nums.length) return;
        
        for(int i = startIndex ; i < nums.length ; i++){
            tempArr.add(nums[i]);
            permutate(tempArr, nums, i + 1);
            tempArr.remove(tempArr.size() - 1);
        }
    }
}
