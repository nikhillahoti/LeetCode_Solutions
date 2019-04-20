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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> output = new ArrayList<>();
        
        if(root == null) return output;
        

	// We maintain a queue where we add nodes at each level.
	// We then group nodes at each level in a single List which is called as levelNodes below.
	// counter keeps track of the number of nodes at the current level.
        queue.offer(root);        

        while(!queue.isEmpty()){
            int counter = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            while(counter > 0){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.offer(node.left);
                if(node.right != null)
                    queue.offer(node.right);
                levelNodes.add(node.val);
                counter--;
            }
            output.add(new ArrayList<>(levelNodes));
        }
        
        return output;
    }
}
