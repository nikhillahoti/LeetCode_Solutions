class Solution {
    public List<String> commonChars(String[] A) {
        
        List<String> output = new ArrayList<>();
        if(A == null || A.length < 1) return output;
        
        HashMap<Character, Integer> hash = new HashMap<>();
        for(int i = 0 ; i < A[0].length() ; i++)
            hash.put(A[0].charAt(i), hash.getOrDefault(A[0].charAt(i), 0) + 1);
        
        for(int i = 1 ; i < A.length ; i++){
            HashMap<Character, Integer> hh = new HashMap<>();
            for(int j = 0 ; j < A[i].length() ; j++){
                if(hash.containsKey(A[i].charAt(j))){
                    hh.put(A[i].charAt(j), hh.getOrDefault(A[i].charAt(j), 0) + 1);
                }
            }
            
            for(Character key: hh.keySet())
                hh.put(key, Math.min(hh.get(key), hash.get(key)));
            
            hash = null;
            hash = (HashMap) hh.clone();
        }
        
        for(Character key: hash.keySet()){
            int count  = hash.get(key);
            while(count > 0){
                output.add(key + "");
                count--;
            }
        }
        
        return output;
    }
}
