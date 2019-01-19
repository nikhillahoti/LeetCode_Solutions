/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Problem 606

class Solution {
    public String tree2str(TreeNode t) {
        return traverseSubTree(t);
    }
    
    public String traverseSubTree(TreeNode root){
        if(root == null) return "";
        
        if(root.left == null && root.right == null) return root.val + "";
        
        String rightPart = traverseSubTree(root.right);
        if(rightPart != ""){
            rightPart = "(" + rightPart + ")";
        }
        return root.val + "(" + traverseSubTree(root.left) + ")" + rightPart;
    }
}
