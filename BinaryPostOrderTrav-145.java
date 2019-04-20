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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        postOrderTrav(root, output);
        return output;
    }
    
    // At each node we check to see if the node is null, and if it is, then we return.
    // Else we traverse the left subTree, then the right subTree and then add the node to the output list
    public void postOrderTrav(TreeNode root, List<Integer> postOrder){
        if(root == null) return;
        postOrderTrav(root.left, postOrder);
        postOrderTrav(root.right, postOrder);
        postOrder.add(root.val);
    }
}
