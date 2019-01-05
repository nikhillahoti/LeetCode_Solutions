
// Problem No-49
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for(int i = 0 ; i < strs.length ; i++){
            
            char tempArray[] = strs[i].toCharArray(); 
            Arrays.sort(tempArray);
            String temp = new String(tempArray);
            if(hash.containsKey(temp)) {
            	List<String> lst = hash.get(temp);
            	lst.add((strs[i]));
                hash.put(temp, lst);
            }
            else {
            	List<String> lst = new ArrayList<>();
            	lst.add(strs[i]);
            	hash.put(temp, lst);
            }
        }
        List<List<String>> output = new ArrayList<>();
        for(String strKey : hash.keySet()){
            output.add(hash.get(strKey));
        }
        return output;
    }
}
