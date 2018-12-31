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
    int sum = 0;
    int L;
    int R;
    public int rangeSumBST(TreeNode root, int L, int R) {
        
        if(root == null) return 0;
        this.L = L;
        this.R = R;
        SearchBST(root);
        return sum;
    }
    
    public void SearchBST(TreeNode root){
        if(root.val >= L && root.val <= R){
            sum += root.val;
            if(root.left != null) SearchBST(root.left);
            if(root.right != null) SearchBST(root.right);
            return;
        }
        if(root.val < L && root.right != null) SearchBST(root.right);
        if(root.val > R && root.left != null) SearchBST(root.left);
    }
}
