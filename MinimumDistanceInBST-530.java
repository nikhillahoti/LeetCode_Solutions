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
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        traverse(root.left , Integer.MAX_VALUE, root.val);
        traverse(root.right , root.val, Integer.MAX_VALUE);
        return min;
    }
    
    int min = Integer.MAX_VALUE;
    public void traverse(TreeNode root, int L, int R){
        if(root == null) return;
        min = Math.min(min, Math.min(Math.abs(root.val - L), Math.abs(R - root.val)));
        
        traverse(root.left, L, root.val);
        traverse(root.right, root.val, R);
    }
}
