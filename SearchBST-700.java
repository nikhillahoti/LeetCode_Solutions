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
    public TreeNode searchBST(TreeNode root, int val) {
        
        if(root == null) return null;
        
        TreeNode temp = root;
        while(temp != null){
            if(temp.val == val) return temp;
            if(temp.val < val)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return temp;
    }
}
