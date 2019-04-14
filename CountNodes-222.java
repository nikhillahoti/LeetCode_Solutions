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
    public int countNodes(TreeNode root) {
        traverse(root);
        return count;
    }
    
    int count = 0;
    public void traverse(TreeNode root){
        if(root == null) return;
        count++;
        traverse(root.left);
        traverse(root.right);
    }
}