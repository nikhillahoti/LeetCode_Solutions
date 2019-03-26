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
    int max = 0;
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int leftPart = 0;
        if(root.left != null) {
            leftPart = getWidthLeft(root.left, -1);
            if(leftPart < 0) leftPart *= -1;
        }
        
        int rightPart = 0;
        if(root.right != null){
            rightPart = getWidthRight(root.right, 1);         
            if(rightPart < 0) rightPart *= -1;
        } 
        
        return Math.max(rightPart + leftPart, max);
    }
    
    public int getWidthLeft(TreeNode root, int width){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return width;
        
        int leftPart = 0;
        if(root.left != null) {
            leftPart = getWidthLeft(root.left, width - 1);
            if(leftPart < 0) leftPart *= -1;
        }
        
        int rightPart = 0;
        if(root.right != null){
            rightPart = getWidthRight(root.right, width + 1);         
            if(rightPart < 0) rightPart *= -1;
        } 
        
        max = Math.max(rightPart + leftPart, max);
        return Math.max(rightPart, leftPart);
    }
    
    public int getWidthRight(TreeNode root, int width){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return width;
        
        int leftPart = 0;
        if(root.left != null) {
            leftPart = getWidthLeft(root.left, width - 1);
            if(leftPart < 0) leftPart *= -1;
        }
        
        int rightPart = 0;
        if(root.right != null){
            rightPart = getWidthRight(root.right, width + 1);         
            if(rightPart < 0) rightPart *= -1;
        } 
        
        max = Math.max(rightPart + leftPart, max);
        return Math.max(rightPart, leftPart);
    }
}
