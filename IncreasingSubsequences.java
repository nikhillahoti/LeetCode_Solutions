
// Problem No. 691
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        //Arrays.sort(nums);
        permutate(new ArrayList<Integer>(), nums, 0);
        return new ArrayList(output);        
    }
    
    Set<List<Integer>> output = new HashSet<List<Integer>>();
    
    public void permutate(List<Integer> tempList, int[] nums, int startIndex){
        if(tempList.size() > 1) {
            output.add(new ArrayList<>(tempList));
        }
        int lastElement = Integer.MIN_VALUE; 
        if(tempList.size() >= 1) lastElement = tempList.get(tempList.size() - 1);
        for(int i = startIndex ; i < nums.length ; i++){
            if(nums[i] < lastElement) continue;
            tempList.add(nums[i]);
            permutate(tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
