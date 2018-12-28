/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem 538
class Solution {
    
    TreeNode tree;
    int sum = 0;
    public TreeNode convert(TreeNode root){
        TreeNode node = new TreeNode(0);
        node.right = null;
        node.left = null;
        if(root.right != null) {
            node.right = convert(root.right);
        }
        sum += root.val;
        node.val += sum;
        if(root.left != null) {
            node.left = convert(root.left);
        }
        return node;
    }
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        return convert(root);
    }
}
