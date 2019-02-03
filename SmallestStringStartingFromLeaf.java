/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem No. 988
class Solution {
    
    String smallestString = "";
    
    public String smallestFromLeaf(TreeNode root) {
        traverseTree(root, new StringBuilder(""));
        return smallestString;
    }
    
    public void traverseTree(TreeNode root, StringBuilder interm){
        if(root == null) return;
        int size = interm.length();
        interm.append((char)(root.val + 97));
        
        if(root.left == null && root.right == null){    
            String str = interm.reverse().toString();
            interm.reverse();
            if(smallestString.isEmpty() || str.compareTo(smallestString) < 0){
                smallestString = str;
            }
        }
        
        traverseTree(root.left, interm);
        traverseTree(root.right, interm);
        interm.deleteCharAt(size);
    }
}
