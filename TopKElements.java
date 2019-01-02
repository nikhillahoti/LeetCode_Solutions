// Problem 692
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0 ; i < words.length ; i++){
            if(hash.containsKey(words[i]))
                hash.put(words[i],hash.get(words[i]) + 1);
            else
                hash.put(words[i],1);
        }
        
        PriorityQueue<HashMap.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        
        for(Map.Entry<String, Integer> entry: hash.entrySet()){
            pq.offer(entry);
        }
        
        System.out.println(pq.size());
        while(pq.size() > k){
            pq.poll();
        }
        System.out.println(pq.size());
        
        List<String> lst = new ArrayList<String>();
        int counter = 0;
        while(counter < k){
            lst.add(0, pq.poll().getKey());
            counter++;
        }
        
        return lst;
        
    }
}
