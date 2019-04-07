/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Map<Node, Node> mapping = new HashMap<>();
            
        Node head2 = null, ptr1 = head, ptr2 = null;
        
        while(ptr1 != null){
            Node temp = null;
            if(mapping.containsKey(ptr1))
                temp = mapping.get(ptr1);
            else{
                temp = new Node();
                temp.val = ptr1.val;
                temp.next = null;
                temp.random = null;
            }
            
            if(head2 == null)
                head2 = temp;
            else
                ptr2.next = temp;
            ptr2 = temp;
            
            mapping.put(ptr1, ptr2);
            
            if(ptr1.random == null){
                ptr1 = ptr1.next;    
                continue;
            } 
            
            if(mapping.containsKey(ptr1.random))
                ptr2.random = mapping.get(ptr1.random);
            else{
                Node temp2 = new Node();
                temp2.val = ptr1.random.val;
                temp2.next = null;
                temp2.random = null;
                ptr2.random = temp2;
                
                mapping.put(ptr1.random, temp2);
            }
                
            ptr1 = ptr1.next;
        }
        
        return head2;
    }
}
