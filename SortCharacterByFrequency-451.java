
import java.util.AbstractMap;

class Solution {
    public String frequencySort(String s) {
       
        if(s == null || s.length() < 1) return "";
       
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char ch : s.toCharArray())
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
       
       
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue() - a.getValue()
        );
       
        for(Character key : hash.keySet()){
            pq.offer(new AbstractMap.SimpleEntry<Character, Integer>(key, hash.get(key)));
        }
       
        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty()){
            Map.Entry<Character, Integer> entry = pq.poll();
            int count = entry.getValue();
            while(count-- > 0){
                sb.append(entry.getKey() + "");
            }
        }
       
        return sb.toString();
    }
}
