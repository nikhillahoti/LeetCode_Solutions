/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            Node old = queue.poll();
            if(old.left != null) queue.offer(old.left);
            if(old.right != null) queue.offer(old.right);
            while(count > 1){
                count--;
                Node neww = queue.poll();
                old.next = neww;
                old = neww;
                if(old.left != null) queue.offer(old.left);
                if(old.right != null) queue.offer(old.right);
            }
        }
        
        return root;
    }
}
















