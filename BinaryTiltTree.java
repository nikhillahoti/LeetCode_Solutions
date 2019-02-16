/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Problem No. 563

class Solution {
    public int findTilt(TreeNode root) {
        getTiltDiff(root);
        return maxSum;
    }
    int maxSum = 0;
    
    public int getTiltDiff(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return root.val;
        
        
        int left = getTiltDiff(root.left);
        int right = getTiltDiff(root.right);
        
        int diff = left - right;
        if(diff < 0) diff *= -1;
        
        maxSum += diff;
        return left + right + root.val;
    }
}
