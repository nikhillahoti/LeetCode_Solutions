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
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root, false);
        return maxSum;
    }
    
    int maxSum = 0;
    public void traverse(TreeNode root, boolean isLeft){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(isLeft)
                maxSum += root.val;
            return;
        }
        
        traverse(root.left, true);
        traverse(root.right, false);
    }
}
