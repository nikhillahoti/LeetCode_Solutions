class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        HashMap<Character, Integer> BMap = new HashMap<>();
        for(int i = 0 ; i < B.length ; i++){
            HashMap<Character, Integer> occur = getOccurences(B[i]);
            for(Character key: occur.keySet())
                BMap.put(key, Math.max(BMap.getOrDefault(key, 0), occur.get(key)));
        }
        
        List<String> output = new ArrayList<>();
        for(int i = 0 ; i < A.length ; i++){
            HashMap<Character, Integer> occur = getOccurences(A[i]);
            boolean flag = false;
            for(Character key: BMap.keySet()){
                if(!(BMap.get(key) <= occur.getOrDefault(key, 0))){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                output.add(A[i]);
        }
        return output;
    }
    
    public HashMap<Character, Integer> getOccurences(String s){
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char ch: s.toCharArray())
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        return hash;
    }
}
