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
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return output;
        traverseSubTree(root, 1);
        return output;
    }
   
    List<Integer> output = new ArrayList<>();
   
    public void traverseSubTree(TreeNode root, int height){
        if(root == null) return;
       
        if(output.size() >= height){
            if(output.get(height - 1) < root.val){
                output.set(height - 1, root.val);
            }   
        }
        else {
            output.add(root.val);           
        }
        traverseSubTree(root.left, height + 1);
        traverseSubTree(root.right, height + 1);
    }
}
