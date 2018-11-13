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
    public int minDepth(TreeNode root) {
       
        if(root == null) return 0;
       
        if (root.left == null && root.right == null) return 1;
       
        int leftSubTreeLength = root.left == null ? Integer.MAX_VALUE : minDepth(root.left) + 1;
        int rightSubTreeLength = root.right == null ? Integer.MAX_VALUE : minDepth(root.right) + 1;
       
        if(leftSubTreeLength < rightSubTreeLength)
            return leftSubTreeLength;
        return rightSubTreeLength;
    }
}