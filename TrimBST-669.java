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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return trim(root, L, R);
    }
    
    public TreeNode trim(TreeNode root, int L, int R){
        if(root == null) return null;
        if(root.val < L) return trim(root.right, L, R);
        if(root.val > R) return trim(root.left, L, R);
        
        TreeNode node = new TreeNode(root.val);
        node.left = trim(root.left, L, R);
        node.right = trim(root.right, L, R);
        return node;
    }
}
