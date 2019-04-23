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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> output = new ArrayList<>();
        if(root == null) return output;
        
	// We use a queue to maintain the list of nodes at each iteration.
	// At Each level, we sum the list of nodes at level and calculate the 
	// Average for the level and store in the output list
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int counter = queue.size();
            int totalNodes = 0;
            double sum = 0;
            while(counter > 0){
                counter--;
                TreeNode node = queue.poll();
                totalNodes++;
                sum += node.val;
                if(node.left != null)
                    queue.offer(node.left); 
                
                if(node.right != null)
                    queue.offer(node.right);
            }
            output.add(sum / totalNodes);
        }
        return output;
    }
}
