/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// We visits the nodes in post order fashion. 
// At each node we check if before visiting this node, did we visit any of the p or q nodes, if yes, then this node can 
// be the lowest common ancestor else if is not a contender

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        preorder(root, p, q);
        return commonAncestor;
    }
    
    TreeNode commonAncestor = null;
    int count = 0;
    
    public void preorder(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return;
        
        int initial = count;
        
        if(root.left != null && commonAncestor == null)
            preorder(root.left, p, q);
        
        if(root.right != null && commonAncestor == null)
            preorder(root.right, p, q);
        
        if(root.val == p.val || root.val == q.val) 
            count++;
                        
        if(initial == 0 && count == 2 && commonAncestor == null)
            commonAncestor = root;
    }
}
