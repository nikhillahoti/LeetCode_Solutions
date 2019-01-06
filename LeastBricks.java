
// Problem No. 554
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int counter = wall.size();
        for(int i = 0 ; i < counter ; i++){
            List<Integer> row = wall.get(i);
            int sum = 0;
            for(int j = 0 ; j < row.size() ; j++){
                sum += row.get(j);
                if(hash.containsKey(sum)){
                    hash.put(sum, hash.get(sum) + 1);
                }
                else{
                    hash.put(sum, 1);
                }
            }
        }
        
        PriorityQueue<HashMap.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b) ->  b.getValue() - a.getValue()
        );
        
        for(HashMap.Entry<Integer, Integer> num: hash.entrySet()){
            pq.offer(num);
        }
        
        if(pq.size() == 1) return wall.size();
            
        pq.poll();
        
        return wall.size() - pq.poll().getValue();
    }
}
