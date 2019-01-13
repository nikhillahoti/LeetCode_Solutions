
// Problem No. 677
class MapSum {

    class TrieNode {
        Map<Character, TrieNode> childrens;
        int value;
        boolean isWord;
        
        public TrieNode(){
            childrens = new HashMap<>();
            int value = 0;
            isWord = false;
        }
    }
    
    /** Initialize your data structure here. */
    TrieNode root;
    public MapSum() {
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode current = root;
        for(char c: key.toCharArray()){
            TrieNode next = current.childrens.get(c);
            if(next == null){
                next = new TrieNode();
                current.childrens.put(c,next);
            }
            // current.value += val;
            current = next;
        }
        current.isWord = true;
        current.value = val;
    }
    
    public int sum(String prefix) {
        TrieNode current = root;
        for(char c: prefix.toCharArray()){
            TrieNode next = current.childrens.get(c);
            if(next == null) return 0;
            current = next;
        }
        return dfs(current);
    }
    
    public int dfs(TrieNode current){
        int sum = 0;
        for(char c : current.childrens.keySet()){
           sum += dfs(current.childrens.get(c));
        }
        return sum + current.value;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
