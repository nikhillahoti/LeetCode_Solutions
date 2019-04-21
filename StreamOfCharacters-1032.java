/*
Implement the StreamChecker class as follows:

    StreamChecker(words): Constructor, init the data structure with the given words.
    query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to newest, including this letter just queried) spell one of the words in the given list.

 

Example:

StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
streamChecker.query('a');          // return false
streamChecker.query('b');          // return false
streamChecker.query('c');          // return false
streamChecker.query('d');          // return true, because 'cd' is in the wordlist
streamChecker.query('e');          // return false
streamChecker.query('f');          // return true, because 'f' is in the wordlist
streamChecker.query('g');          // return false
streamChecker.query('h');          // return false
streamChecker.query('i');          // return false
streamChecker.query('j');          // return false
streamChecker.query('k');          // return false
streamChecker.query('l');          // return true, because 'kl' is in the wordlist

 

Note:

    1 <= words.length <= 2000
    1 <= words[i].length <= 2000
    Words will only consist of lowercase English letters.
    Queries will only consist of lowercase English letters.
    The number of queries is at most 40000.
*/


class StreamChecker {

    // We insert the list of dictionary words in a Trie Data Structure.
    Node root = new Node();
    
    public StreamChecker(String[] words) {
        for(int i = 0 ; i  < words.length ; i++){
            insertWord(root, words[i], 0);
        }
    }
    
    public void insertWord(Node node, String word, int index){
        Node child = null;
        
        if(index == word.length()){
            node.isWord = true;
            node.word = word;
            return;
        }
        
        if(!node.mapping.containsKey(word.charAt(index))){
            child = new Node();
            node.mapping.put(word.charAt(index), child);
        }
        else 
            child = node.mapping.get(word.charAt(index));
        
        insertWord(child, word, index + 1);
    }
    
    // During the Stream phase, we visit every node in the Trie DS which begin at the current node. 
    // We also store a partially matched node to the Queue in order to check in the next iteration 
    // if it matches the current letter and forms a Word.
    Queue<Node> queue = new LinkedList<>();
    
    public boolean query(char letter) {
        if(root.mapping.containsKey(letter))
            queue.offer(root);
        
        boolean flag = false;
        if(!queue.isEmpty()){  
	    // Counter helps us in traversing only those nodes in the previous iteration and the nodes added in the current iteration
	    // are skipped and are checked in the next iteration.
            int counter = queue.size();
            while(counter > 0){
                Node currentNode = queue.poll();
                if(currentNode.mapping.containsKey(letter)){
                    Node child = currentNode.mapping.get(letter);
                    if(child.isWord == true)
                        flag = true;
                    queue.offer(child);
                }
                counter--;
            }
        }
        return flag;
    }
    
    class Node {
        public Map<Character, Node> mapping = new HashMap<>();
        public boolean isWord = false;
        public String word = null;
    }
}



/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
