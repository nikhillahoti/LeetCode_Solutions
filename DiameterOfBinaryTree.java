/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem No. 543
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        //if(root.left == null && root.right == null) return 1;
        int value = traversechildTree(root);
        return Math.max(value, maxLen);
    }
    
    int maxLen = -1;
    
    public int traversechildTree(TreeNode root){
        if(root.left == null && root.right == null) return 0;
        int leftSubTreeLength = -1, rightSubTreeLength = -1;
        if(root.left != null) leftSubTreeLength = traversechildTree(root.left);
        if(root.right != null) rightSubTreeLength = traversechildTree(root.right);
        
        leftSubTreeLength++; rightSubTreeLength++;
        
        if(leftSubTreeLength + rightSubTreeLength > maxLen){
            maxLen = leftSubTreeLength + rightSubTreeLength;
        }
        
        return Math.max(leftSubTreeLength, rightSubTreeLength);
    }
}
