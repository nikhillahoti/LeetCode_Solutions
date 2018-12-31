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
    int counter = 0;
    public int countNodes(TreeNode root) {
        
        if(root == null) return 0;
        if(root.left == null) return 1;
        
        // Calculating the height of the Tree	
        TreeNode temp = root;
        int height = 0;
        while(temp.left != null){
            height++;
            temp = temp.left;
        }
        int low = 0;
        int high = (int) Math.pow(2, height) - 1;
        temp = root;
        int remHeight = height;
        while(remHeight > 1){
            if(checkMiddleNode(temp, remHeight)){
                temp = temp.right;
                low = (low + high + 1) / 2;
            }
            else{
                high = (low + high + 1) / 2 - 1; 
                temp = temp.left;
            }
            remHeight--;
        }
        
        if(temp.left != null) low++; 
        if(temp.right != null) low++;
        
        System.out.println(low);
        System.out.println(high);
        return (int) Math.pow(2, height) - 1 + low;

    }
    
    public boolean checkMiddleNode(TreeNode root, int height){
        if(height > 1){
            root = root.left;
            height -= 1;
            while(height > 1){
                root = root.right;
                height--;
            }    
        }
        if(root.right != null) {
            return true;   
        }
        return false;
    }
    
}
