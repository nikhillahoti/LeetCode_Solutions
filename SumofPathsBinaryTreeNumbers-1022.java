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
    public int sumRootToLeaf(TreeNode root) {
        traverse("", root);
        return (int) maxSum % (int) (Math.pow(10, 9) + 7);
    }
    
    long maxSum = 0;
    
    public void traverse(String sb, TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            maxSum += getValue(root.val + new StringBuilder(sb).reverse().toString());    
            maxSum %= (int) (Math.pow(10, 9) + 7);
            return;
        }
        traverse(sb + root.val, root.left);
        traverse(sb + root.val, root.right);
    }
    
    public long getValue(String str){
        long value = 0, mul = 1, modd = (int) (Math.pow(10, 9) + 7); 
        for(int i = 0 ; i < str.length(); i++){
            value %= modd;
            mul %= modd;
            if(str.charAt(i) == '1')
                value += mul;
            mul *= 2;
        }
        return value;
    }
    
}
