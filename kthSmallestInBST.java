// Problem number: 230

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
    int k1 = 0;
    public int kthSmallest(TreeNode root, int k) {
        k1 = k;
        return InOrderTraversal(root);
    }
    
    public int InOrderTraversal(TreeNode root){
        if(root == null){
            return -1;
        }
        int value = InOrderTraversal(root.left);
        if (value != -1){
            return value;
        }
        k1--;
        if(k1 == 0){
            return root.val;
        }
        return InOrderTraversal(root.right);
    }
}
