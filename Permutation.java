// Problem No. 42
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> numss = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            numss.add(nums[i]);
        }
        permutate(new ArrayList<Integer>(), numss);
        return output;
    }
    
    List<List<Integer>> output = new ArrayList<>();
    
    public void permutate(List<Integer> tempList, List<Integer> nums){
        if(nums.size() == 0){
            output.add(new ArrayList<>(tempList));
            return;
        }
        for(int i = 0 ; i < nums.size() ; i++){
            tempList.add(nums.get(i));
            nums.remove(i);
            permutate(tempList, nums);
            int tep = tempList.remove(tempList.size() - 1);
            nums.add(i, tep);
        }
    }
}
