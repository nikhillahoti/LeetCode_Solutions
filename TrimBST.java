/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Problem No. 669

class Solution {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        return TrimTree(root, L, R);
    }
    
    public TreeNode TrimTree(TreeNode root, int L, int R){
        if(root == null) return null;
        
        if(root.val >= L && root.val <= R){
            root.left = TrimTree(root.left, L, R);
            root.right = TrimTree(root.right, L, R);
            return root;
        }
        else{
            if(root.val > L) return TrimTree(root.left, L, R);
            return TrimTree(root.right, L, R);
        }
    }
    
}
