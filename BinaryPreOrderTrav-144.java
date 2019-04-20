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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        preOrderTrav(root, output);
        return output;
    }
    
    // At each node, check to see if the node is null, if it is then return. Else add the node to output list,
    // visit the left subTree and then the right subtree passing the output list along the way
    public void preOrderTrav(TreeNode root, List<Integer> preOrder){
        if(root == null) return;
        preOrder.add(root.val);
        preOrderTrav(root.left, preOrder);
        preOrderTrav(root.right, preOrder);
    }
}
