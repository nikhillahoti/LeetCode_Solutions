/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem No. 965
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) return true;
        
        boolean flag = true;
        if(root.left != null)
            flag = checkSubTree(root.left, root.val);
        if(root.right != null)
            flag = flag && checkSubTree(root.right, root.val);
        return flag;
    }
    
    public boolean checkSubTree(TreeNode root, int value){
        if(root.val != value) return false;
        boolean flag = true;
        if(root.left != null)
            flag = checkSubTree(root.left, value);
        if(root.right != null)
            flag = flag && checkSubTree(root.right, value);
        return flag;
    }
}
