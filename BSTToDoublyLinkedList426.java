/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    public Node treeToDoublyList(Node root) {
       
        if(root == null) return root;
       
        linkNodes(root,  null, null);
       
        Node rightMostNode = root;
        while(rightMostNode.right != null)
            rightMostNode = rightMostNode.right;
       
        Node leftMostNode = root;
        while(leftMostNode.left != null)
            leftMostNode = leftMostNode.left;
   
        leftMostNode.left = rightMostNode;
        rightMostNode.right = leftMostNode;
           
        return leftMostNode;
    }
   
    public void linkNodes(Node root, Node pred, Node succ){
       
        if(root.left != null)
            linkNodes(root.left, pred, root); 
        else {
            root.left = pred;
            if(pred != null){
                pred.right = root;
            }
        }
       
        if(root.right != null)
            linkNodes(root.right, root, succ);
        else {
            root.right = succ;
            if(succ != null){
                succ.left = root;
            }
        }
    }
   
}
