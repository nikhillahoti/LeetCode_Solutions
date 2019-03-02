class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> output = new ArrayList<>();
        if(nums == null || nums.length < 1) return output;
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int num: nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> {
                return hash.get(b) - hash.get(a);
            }
        );
        
        for(Integer key: hash.keySet()){
            pq.offer(key);
        }
        
        while( k > 0 && !pq.isEmpty()){
            output.add(pq.poll());
            k--;
        }
        return output;
    }
}
