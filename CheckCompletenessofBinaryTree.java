
// Problem No. 958

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
    public boolean isCompleteTree(TreeNode root) {
        
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int idealSize = 1;
        boolean flag = false;
        
        while(!queue.isEmpty()){
            int count = queue.size();
            int temp = 0;
            
            while(temp < count){
                TreeNode currentNode = queue.remove();
                temp++;
                if(flag) {
                    if(currentNode.left != null || currentNode.right != null){
                        //System.out.println("Here");
                        return false;
                    }
                    continue;
                }
                
                if(currentNode.left == null && currentNode.right != null) return false;
                
                // set flag on breaking the chain
                if(currentNode.left == null || currentNode.right == null) flag = true;
                
                if(currentNode.left != null) queue.add(currentNode.left);
                if(currentNode.right != null) queue.add(currentNode.right);
            }
            
            if(temp != idealSize && !queue.isEmpty()) {
                return false; 
            }
            
            if(flag == true){
                while(!queue.isEmpty()){
                    TreeNode node = queue.remove();
                    if(node.left != null || node.right != null) return false;
                }
            }
            idealSize *= 2;
        }
        return true;
    }
}
