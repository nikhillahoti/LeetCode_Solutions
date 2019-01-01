/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem: 257
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> temp = new ArrayList<String>();
        if(root == null) return temp;
        String IntermPath = root.val + "";
        if(root.left == null && root.right == null){
            temp.add(IntermPath);
        } 
        else{
            if(root.left != null){
                temp.addAll(getPathFromChildren(root.left, IntermPath));
            }
            if(root.right != null){
                temp.addAll(getPathFromChildren(root.right, IntermPath));
            }
        }
        return temp;
        
    }
    
    List<String> getPathFromChildren(TreeNode root, String IntermPath){
        IntermPath += "->" + root.val;
        List<String> temp = new ArrayList<String>();
        if(root.left == null && root.right == null){
            temp.add(IntermPath);
        } 
        else{
            if(root.left != null){
                temp.addAll(getPathFromChildren(root.left, IntermPath));
            }
            if(root.right != null){
                temp.addAll(getPathFromChildren(root.right, IntermPath));
            }
        }
        return temp;
    }
}
