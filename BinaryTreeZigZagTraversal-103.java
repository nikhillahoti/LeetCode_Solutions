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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
       
        boolean flag = false;
       
        List<List<Integer>> output = new ArrayList<>();
       
        while(!queue.isEmpty()){
            int counter = queue.size();
            List<Integer> lstLevel = new ArrayList<>();
            while(counter > 0){
                TreeNode current = queue.poll();
                counter--;
                if(current == null) continue;
               
                queue.offer(current.left);
                queue.offer(current.right);
                lstLevel.add(current.val);
            }
           
            if(flag)
                Collections.reverse(lstLevel);
           
            if(lstLevel.size() > 0)
                output.add(new ArrayList<>(lstLevel));
            flag = !flag;
        }
       
        return output;
    }
}
