// Problem 94

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
   
    List<Integer> output = new ArrayList<Integer>();
   
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return output;
        }
        inorderTraverse(root);
        return output;
    }
   
    public void inorderTraverse(TreeNode root){
        if (root == null){
            return;
        }
        inorderTraverse(root.left);
        output.add(root.val);
        inorderTraverse(root.right);
    }
}
