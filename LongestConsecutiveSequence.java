
// Problem No. 128
class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length < 1) return 0;
        
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            hash.add(nums[i]);
        }
        
        List<Integer> lst = new ArrayList<>(hash);
        int counter = lst.size();
        HashSet<Integer> visited = new HashSet<>();    
        
        int maxCount = 0;
        for(int i = 0 ; i < counter ; i++){
            if(visited.contains(lst.get(i))) continue;
            
            int temp = lst.get(i);
            visited.add(temp);
            int count = 1;
            temp--;
            while(hash.contains(temp)){
                count++; 
                visited.add(temp);
                temp--;
            }
            temp = lst.get(i);
            temp++;
            while(hash.contains(temp)){
                count++; 
                visited.add(temp);
                temp++;
            }
            
            if(count > maxCount) {
                maxCount = count;
            }
            
        }
        
        return maxCount;
    }
}
