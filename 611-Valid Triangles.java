class Solution {
    public int triangleNumber(int[] nums) {
        
        if(nums == null || nums.length < 1) return 0;
        
        Arrays.sort(nums);
        traverse(new ArrayList<Integer>(), 0, 0, nums);
        
        return possibleTriangles;
    }

    int possibleTriangles = 0;
    public void traverse(ArrayList<Integer> currentList, int index, int sum, int[] nums){
        if(currentList.size() == 2){
            for(int i = index ; i < nums.length ; i++){
                if(nums[i] < sum)
                    possibleTriangles++;
            }
        }
        else {
            for(int i = index ; i < nums.length ; i++){
                currentList.add(nums[i]);
                traverse(currentList, i+1, sum + nums[i], nums);
                currentList.remove(currentList.size() - 1);
            }
        }
    }
}
