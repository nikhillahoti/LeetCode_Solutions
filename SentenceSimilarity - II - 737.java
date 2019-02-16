// Problem No. 737

// Used Union find approach to represent similarity between the words

class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        
        if(words1 == null || words2 == null || words1.equals("") || words2.equals("")) return false;
        if(words1.length != words2.length) return false;
        
        unionAll(pairs);
        for(int i = 0 ; i < words1.length ; i++){
            String parent1 = getParent(words1[i]);
            String parent2 = getParent(words2[i]);
            if(!parent1.equals(parent2)) return false;
        }
        
        return true;   
    }
    
    HashMap<String, String> hash = new HashMap<>();
    public void unionAll(String [][] pairs){
        for(int i = 0 ; i < pairs.length ; i++){
            if(!(hash.containsKey(pairs[i][0]) || hash.containsKey(pairs[i][1]))){
                // No commong parent for both the entries
                hash.put(pairs[i][0], pairs[i][0]);
                hash.put(pairs[i][1], pairs[i][0]);
            }
            else {
                String parent = null;
                if(hash.containsKey(pairs[i][0])){
                    parent = getParent(pairs[i][0]);
                    setParent(pairs[i][1], parent);
                }
                else {
                    parent = getParent(pairs[i][1]);
                    setParent(pairs[i][0], parent);
                }
            }
        }
    }
    
    public String getParent(String child){
        while(true){
            String parent = hash.get(child);
            if(parent == null) return "";
            if(parent.equals(child)) return child;
            child = parent;
        }
    }
    
    public void setParent(String child, String parent){
        String currentParent = hash.get(child);
        hash.put(child, parent);
        if(currentParent != null && !child.equals(currentParent))
            setParent(currentParent, parent);
    }
    
}
