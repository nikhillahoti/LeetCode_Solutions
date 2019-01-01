// Problem No.260
class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(hash.contains(nums[i])){
                hash.remove(nums[i]);
            }
            else{
                hash.add(nums[i]);
            }
        }
        Iterator<Integer> it = hash.iterator();
        int [] result = new int[2];
        int counter = 0;
        while (it.hasNext()) {
            result[counter++] = it.next().intValue();
        }
        return result;        
    }
}
