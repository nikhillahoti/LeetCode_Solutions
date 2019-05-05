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
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    
    int gCount = 0;
    public void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.right);
        gCount += root.val;
        root.val = gCount;
        traverse(root.left);
    }
}
