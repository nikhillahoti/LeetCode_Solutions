// Next Right Pointers in Each Node: Problem 116

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
     public void connect(TreeLinkNode root) {
         if(root == null) return;
        linkNodes(root.left, root.right);
    }
    
    public void linkNodes(TreeLinkNode p1, TreeLinkNode p2){
        if(p1 == null) return;
        
        p1.next = p2;
        
        linkNodes(p1.left, p1.right);
        linkNodes(p2.left, p2.right);
        
        linkLeftToRight(p1.right, p2.left);
    }
    
    public void linkLeftToRight(TreeLinkNode p1, TreeLinkNode p2){
        if(p1 == null) return;
        p1.next = p2;
        linkLeftToRight(p1.right, p2.left);
    }
}
