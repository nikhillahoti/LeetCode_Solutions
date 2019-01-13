/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Problem No. 99
class Solution {
    public void recoverTree(TreeNode root) {
        violation = true;
        while(violation){
            violation = false;    
            validateSubTree(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
        }
    }
    
    public boolean violation = false;
    public boolean minViolation = false;
    public TreeNode violatedNode = null;
    
    public boolean validateSubTree(int leftMin, int rightMax, TreeNode root){
        
        /*System.out.println(leftMin);
        System.out.println(rightMax);
        System.out.println(root.val);
        System.out.println("-------");*/

        
        if(root.val < leftMin){
            minViolation = true;
            violation =true;
            violatedNode = root;
            return true;
        }
        else{
            if(root.val > rightMax){
                minViolation = false;
                violation = true;
                violatedNode = root;
                return true;
            }
        }
        
        if(root.left != null){
            if(validateSubTree(leftMin, root.val, root.left)){
                if(!minViolation && violation){
                    int temp = violatedNode.val;
                    violatedNode.val = root.val;
                    root.val = temp;
                    return false;    
                }
                return true;
            }
        }
        
        if(root.right != null){
            if(validateSubTree(root.val, rightMax, root.right)){
                if( minViolation && violation){
                    int temp = violatedNode.val;
                    violatedNode.val = root.val;
                    root.val = temp;
                    return false;   
                }
                return true;
            }   
        }

        return false;
    }
}
