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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int leftWidth = 0, rightWidth = 0;
        if(root.left != null)
        {
            int [] result = calculateWidth(root.left);
            result[0] += 1;
            result[1] -= 1;
            leftWidth = Math.max(result[0], leftWidth);
            rightWidth = Math.max(result[1], rightWidth);
        }
        
        if(root.right != null){
            int [] result = calculateWidth(root.right);
            result[0] -= 1;
            result[1] += 1;
            leftWidth = Math.max(result[0], leftWidth);
            rightWidth = Math.max(result[1], rightWidth);
        }
        return leftWidth + rightWidth;
    }
    
    public int[] calculateWidth(TreeNode root){
        
        if(root.left == null && root.right == null) return new int[]{0,0};
        
        int leftWidth = 0, rightWidth = 0;
        
        if(root.left != null){
            int [] result = calculateWidth(root.left);
            result[0] += 1;
            result[1] -= 1;
            leftWidth = Math.max(result[0], leftWidth);
            rightWidth = Math.max(result[1], rightWidth);
        }
        
        if(root.right != null){
            int [] result = calculateWidth(root.right);
            result[0] -= 1;
            result[1] += 1;
            leftWidth = Math.max(result[0], leftWidth);
            rightWidth = Math.max(result[1], rightWidth);
        }
        
        return new int[]{leftWidth, rightWidth};
    } 
}
