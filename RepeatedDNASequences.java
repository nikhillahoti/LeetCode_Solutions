
// Problme No. 187
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> repeated = new HashMap<>();
        for(int i = 0 ; i < s.length() - 9 ; i++){
            String strSub = s.substring(i, i +10);
            System.out.println(strSub);
            if(repeated.containsKey(strSub)){
                repeated.put(strSub, repeated.get(strSub) + 1);
            }
            else {
                repeated.put(strSub, 1);
            }
        }
        
        List<String> output = new ArrayList<>();
        for(String key: repeated.keySet()){
            if(repeated.get(key) >= 2){
                output.add(key);
            }
        }
        
        return output;
    }
}
