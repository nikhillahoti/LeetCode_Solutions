/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Set<Node> visited = new HashSet<>();
       
        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> mapping = new HashMap<>();
       
        queue.offer(node);
        Node head = null;
       
        while(!queue.isEmpty()){
           
            Node current = queue.poll();
            Node myNode = null;
            if(visited.contains(current)) continue;
            visited.add(current);
           
            if(mapping.containsKey(current))
                myNode = mapping.get(current);
            else {
                myNode = new Node(current.val);
            }
           
            List<Node> neigh = new ArrayList<>();
            List<Node> curr = current.neighbors;
           
            for(int i = 0 ; i < curr.size() ; i++){
               
                if(mapping.containsKey(curr.get(i)))
                    neigh.add(mapping.get(curr.get(i)));
                else {
                    Node n = new Node();
                    n.val = curr.get(i).val;
                    mapping.put(curr.get(i), n);
                    neigh.add(n);
                }
               
                if(!visited.contains(curr.get(i)))
                    queue.offer(curr.get(i));
            }
           
            myNode.neighbors = new ArrayList<>(neigh);
            mapping.put(current, myNode);
           
            if(head == null)
                head = myNode;
        }
       
        return head;
       
    }
}
