class Trie {

    class Node {
        boolean isWord;
        Map<Character, Node> children = null;
        
        public Node(){
            this.isWord = false;
            children = new HashMap<>();
        }
    }
    
    /** Initialize your data structure here. */
    
    Node root = null;
    public Trie() {
        this.root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
         insertHelper(word, 0, root);  
    }
    
    public void insertHelper(String word, int index, Node node){
        if(index == word.length()) {
            node.isWord = true;
            return;   
        }
        
        Map<Character, Node> childrens = node.children;
        
        if(childrens.containsKey(word.charAt(index)))
            insertHelper(word, index + 1, childrens.get(word.charAt(index)));
        else {
            Node n = new Node();
            childrens.put(word.charAt(index), n);
            insertHelper(word, index + 1, n);
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }
    
    public boolean searchHelper(String word, int index, Node node){
        if(index == word.length()) return node.isWord;
        if(node == null) return false;
        
        if(!node.children.containsKey(word.charAt(index))) 
            return false;
        return searchHelper(word, index + 1, node.children.get(word.charAt(index)));
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchHelperPre(prefix, 0, root);
    }
    
    public boolean searchHelperPre(String word, int index, Node node){
        if(index == word.length()) return true;
        if(node == null) return false;
        
        if(!node.children.containsKey(word.charAt(index))) 
            return false;
        return searchHelperPre(word, index + 1, node.children.get(word.charAt(index)));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
