/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Problem - 515
class Solution {
    
    List<Integer> output = new ArrayList<>();
    
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return output;
        checkForLargest(root, 0);
        return output;
    }
    
    public void checkForLargest(TreeNode root, int height){
        if(height >= output.size()){
            System.out.println(root.val + "->" + height);
            output.add(root.val);
        }
        else{
            if(output.get(height) < root.val){
                System.out.println(root.val + "->" + height);
                output.set(height, root.val);
            }
        }
        
        if(root.left != null) checkForLargest(root.left, height + 1);
        if(root.right != null) checkForLargest(root.right, height + 1);
    }
}
