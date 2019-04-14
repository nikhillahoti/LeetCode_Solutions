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
    public int maxAncestorDiff(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        traverse(root.left, root.val, root.val);
        traverse(root.right, root.val, root.val);
        return maxDiff;
    }
    
    int maxDiff = Integer.MIN_VALUE;
    public  void traverse(TreeNode root, int min, int max){
        if(root == null) return;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        
        maxDiff = Math.max(maxDiff, max - min);
        traverse(root.left, min, max);
        traverse(root.right, min, max);
    }
}
