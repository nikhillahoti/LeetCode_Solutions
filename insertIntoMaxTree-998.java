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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        root = construct(root, val);
        return root;
    }
    
    public TreeNode construct(TreeNode root, int val){
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        
        if(root.val > val){
            if(root.right == null){
                root.right = new TreeNode(val);
                return root;
            }
            root.right = construct(root.right, val);
            return root;
        }
        TreeNode node = new TreeNode(val);
        node.left = root;
        return node;
        
    }
}
