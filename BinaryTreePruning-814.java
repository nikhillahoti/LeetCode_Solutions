/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        traverse(root);
        return root;
    }
    
    public boolean traverse(TreeNode root){
        if(root == null) return false;
        
        if(root.left == null && root.right == null){
            if(root.val == 1) return true;
            return false;
        }
        
        boolean leftPart = traverse(root.left);
        if(!leftPart)
            root.left = null;
        
        boolean rightPart = traverse(root.right);
        if(!rightPart)
            root.right = null;
            
        if(!leftPart && !rightPart && root.val == 0)
            return false;
        return true;
    }
}
