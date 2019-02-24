/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Problem No. 113

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        target = sum;
        traverse(root, 0, new ArrayList<Integer>());
        return output;
    }
    
    int target;
    List<List<Integer>> output = new ArrayList<>();
    public void traverse(TreeNode root, int sum, ArrayList<Integer> interm){
        if(root == null) return;
        
        if(root.left == null && root.right == null){
            if(sum + root.val == target){
                interm.add(root.val);
                output.add(new ArrayList<>(interm));
                interm.remove(interm.size() - 1);
            }
        }
        sum += root.val;
        interm.add(root.val);
        traverse(root.left, sum, interm);
        traverse(root.right, sum, interm);
        interm.remove(interm.size() - 1);
        
    }
    
}
