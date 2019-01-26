/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Problem No. 623
class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root == null) return newRoot;
        if(d == 1){
            newRoot = new TreeNode(v);
            newRoot.left = root;
        }
        else{
            newRoot = root;
            addOne(root, v, d, 1);
        }
        return newRoot;
    }
    
    TreeNode newRoot;
    public void addOne(TreeNode root, int v, int d, int height){
        if(root == null) return;
        if(height == d - 1){
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            
            left.left = root.left;
            right.right = root.right;
            
            root.left = left;
            root.right = right;
        }
        else {
            addOne(root.left, v, d, height + 1);
            addOne(root.right, v, d, height + 1);
        }
    }
}
