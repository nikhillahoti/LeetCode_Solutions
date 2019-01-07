/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem. 114
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flattenSubtree(root);        
    }
    
    public TreeNode flattenSubtree(TreeNode root){
        if(root.left == null && root.right == null) return root;
        
        TreeNode temp = root;
        TreeNode rightPart = root.right;
        if(root.left != null){
            temp.right = flattenSubtree(root.left);
            temp.left = null;
            while(temp.right != null) temp = temp.right;
        }
        if(rightPart != null){
            temp.right = flattenSubtree(rightPart);
            temp.left = null;
        }
        return root;
    }
}
