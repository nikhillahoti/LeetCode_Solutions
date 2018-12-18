/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
// Problem Number: 429

class Solution {
    public ArrayList<List<Integer>> traversal = new ArrayList();
    
    public void traverse(Node root, int height){
        
        if (root == null) return;
        
        if(this.traversal.size() <= height){
            this.traversal.add(new ArrayList<Integer>());
        }
        this.traversal.get(height).add(root.val);
        for (int i = 0 ; i < root.children.size() ; i++){
            traverse(root.children.get(i), height + 1);
        }
    }
    
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) return traversal;
        
        traverse(root, 0);
        return this.traversal;
    }
}