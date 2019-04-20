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
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return maxDepth;
    }
    int maxDepth = 0;
    
    public void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        depth += 1;
        if(root.left == null && root.right == null)
        {
            maxDepth = Math.max(maxDepth, depth);    
            return;
        }
        
        dfs(root.left, depth);
        dfs(root.right, depth);
    }
}
