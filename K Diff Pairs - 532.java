// Problem No . 532
class Solution {
    public int findPairs(int[] nums, int k) {
        
        if(k < 0) return 0;
        
        if(nums == null || nums.length < 1) return 0;
        HashMap<Integer, Integer> hash = new HashMap<>();    
        
        if(k == 0){
            int maxCount = 0;
            HashSet<Integer> visited = new HashSet<>();
            for(int i = 0 ; i < nums.length ; i++){
                if(visited.contains(nums[i])) continue;
                if(hash.containsKey(nums[i])) {
                    visited.add(nums[i]);
                    maxCount++;   
                }
                hash.put(nums[i], 0);
            }
            return maxCount;
        }
       
        for(int i = 0 ; i < nums.length ; i++){
            hash.put(nums[i], 0);   
        }
        
        int count = 0;
        for(Integer key : hash.keySet()){
            if(hash.containsKey(key - k))
                count++;
        }
        return count;
    }
}
