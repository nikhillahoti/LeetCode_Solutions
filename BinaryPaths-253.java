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
    
    List<String> paths = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        traverse(root, "");
        return paths;
    }
    
    public void traverse(TreeNode root, String intermPath){
        if(root == null) return;    
        if(root.left == null && root.right == null){
            paths.add(intermPath + root.val);
        }
        else
        {
            traverse(root.left, intermPath + root.val + "->");
            traverse(root.right, intermPath + root.val + "->");
        }
    }
}
