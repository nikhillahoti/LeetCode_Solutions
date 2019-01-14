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
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        Traverse(root);
        return root;
    }
    
    public void Traverse(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            sum += root.val;
            root.val = sum;
            return;
        }
        Traverse(root.right);
        sum += root.val;
        root.val = sum;
        Traverse(root.left);
    }
}
