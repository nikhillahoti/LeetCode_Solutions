/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem No. 110
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        
        int leftSubTreeHeight = postOrderTraversal(root.left);
        int rightSubTreeHeight = postOrderTraversal(root.right);
        
        if(leftSubTreeHeight == -1 || rightSubTreeHeight == -1) return false;
        
        int diff = rightSubTreeHeight - leftSubTreeHeight;
        if(diff < 0) diff *= -1;
        
        if(diff > 1) return false;
        return true;
    }
    
    public int postOrderTraversal(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int leftSubTreeHeight = postOrderTraversal(root.left);
        int rightSubTreeHeight = postOrderTraversal(root.right);
        
        if(leftSubTreeHeight == -1 || rightSubTreeHeight == -1) return -1;
        
        int diff = rightSubTreeHeight - leftSubTreeHeight;
        if(diff < 0) diff *= -1;
        
        if(diff > 1) return -1;
        return Math.max(leftSubTreeHeight + 1, rightSubTreeHeight + 1);
    }
}