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
class Solution {
    public int maxDepth(Node root) {
        traverse(root, 1);
        return depth;
    }
    
    int depth = 0;
    public void traverse(Node root, int steps){
        if(root == null) return;
        if(root.children == null || root.children.size() == 0){
            depth = Math.max(depth, steps);
            return;
        }
        
        for(int i = 0 ; i < root.children.size() ; i++)
            traverse(root.children.get(i), steps + 1);
    }
    
}