
/*

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.



*/

class WordDictionary {

    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    Trie root = new Trie();
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWordHelper(word, 0, root);
    }
    
    public void addWordHelper(String word, int index, Trie node){
        if(index == word.length()) {
            node.isWord = true;
            return;
        }
        Trie child = null;
        if(node.childrens.containsKey(word.charAt(index)))
            child = node.childrens.get(word.charAt(index));
        else{
            child = new Trie();
            node.childrens.put(word.charAt(index), child);            
        }
            
        addWordHelper(word, index + 1, child);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Queue<Trie> queue = new LinkedList<>();
        queue.offer(root);
        
        int index = 0;
        while(!queue.isEmpty()){
            int counter = queue.size();
            while(counter-- > 0){
                Trie current = queue.poll();
                if(word.charAt(index) == '.'){
                    Map<Character, Trie> childs = current.childrens;
                    for(Character key: childs.keySet())
                        queue.offer(childs.get(key));
                }
                else {
                    if(current.childrens.containsKey(word.charAt(index)))
                        queue.offer(current.childrens.get(word.charAt(index)));
                }
            }
            index++;
            if(index == word.length()) break;            
        }
        
        while(!queue.isEmpty()){
            Trie current = queue.poll();
            if(current.isWord) return true;
        }
        
        return false;
    }
    
    
    class Trie {
        Map<Character, Trie> childrens = null;
        boolean isWord = false;
        public Trie(){
            childrens = new HashMap<>();
        }
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
