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
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return total;
    }
   
    int total = 0;
   
    public void traverse(TreeNode root, int sum){
        if(root == null) return;
        int value = (sum * 10) + root.val;
        if(root.left == null && root.right == null) {
            total += value;
            return;
        }
        traverse(root.left, value);
        traverse(root.right, value);
    }
}


