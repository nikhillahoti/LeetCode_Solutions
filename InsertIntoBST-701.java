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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        
        if(root == null) return new TreeNode(val); 
        
        TreeNode temp = root;
        while(temp != null){
            if(temp.val >= val){
                if(temp.left == null){
                    temp.left = new TreeNode(val);
                    break;
                }
                temp = temp.left;
            }
            else {
                if(temp.right == null){
                    temp.right = new TreeNode(val);
                    break;
                }
                temp = temp.right;
            }
        }
        return root;
    }
}
