class LRUCache {

    class ListNode {
        int value;
        int key;
        ListNode prev;
        ListNode next;
       
        public ListNode(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
   
    ListNode head;
    ListNode last;
    int currentCapacity = 0;
    int capacity;
    HashMap<Integer, ListNode> hash = new HashMap<>();
   
    public LRUCache(int capacity) {
        this.capacity = capacity;
        last = null;
        head = null;
    }
   
    public int get(int key) {
        if(hash.containsKey(key)){
           
            if(head != null && head.key == key) 
                return head.value;
           
            ListNode temp = hash.get(key);
            
            temp.prev.next = temp.next;
            if(temp.next != null)
                temp.next.prev = temp.prev;
            else 
                last = temp.prev;
           
            temp = new ListNode(key, temp.value);
            temp.next = head;
            head.prev = temp;
            head = temp;
           
            hash.put(key, head);
            return head.value;
        }
        return -1;
    }
   
    public void put(int key, int value) {
        if(hash.containsKey(key)){
            if(head != null && head.key == key) {
                head.value = value;
                return;
            }
                
            ListNode temp = hash.get(key);
            temp.prev.next = temp.next;
            if(temp.next != null)
                temp.next.prev = temp.prev;
            else 
                last = temp.prev;
           
            temp = new ListNode(key, value);
            temp.next = head;
            head.prev = temp;
            head = temp;
           
            hash.put(key, head);
        }
        else {
            ListNode temp = new ListNode(key,value);      
            if(currentCapacity == capacity){
                hash.remove(last.key);
                last = last.prev;
                if(last != null)
                    last.next = null;
                
                head.prev = temp;
                temp.next = head;
                head = temp;
               
                hash.put(key,head);
            }
            else {
                currentCapacity++;
                if(head == null){
                    head = temp;
                    last = head;
                    hash.put(key, head);
                }
                else {
                    temp.next = head;
                    head.prev = temp;
                    head = temp;
                    hash.put(key, head);
                }
            }           
        }
        //System.out.println("\t Last val" + last.value);        
        //printLinkedListback(last);
        //printLinkedList(head);
        /*System.out.println("\n\nhere is the HashSet -->");
        for(Integer a : hash.keySet()){
            System.out.print("\t" + a);
        }*/
    }
    
    void printLinkedList(ListNode node){
        System.out.println("\n\nHere is the list last -->");
        while(node != null){
            System.out.print("\t" + node.value + "=>" + node.key);
            node = node.next;
        }
    }
    
    void printLinkedListback(ListNode node){
        System.out.println("\n\nHere is the list prev -->");
        while(node != null){
            System.out.print("\t" + node.value + "=>" + node.key);
            node = node.prev;
        }
    }
        
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
