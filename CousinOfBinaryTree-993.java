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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        
        int parent1 = -1, parent2 = -1;
        Queue<TreeNode> childrens = new LinkedList<>();
        childrens.offer(root);
        while(!childrens.isEmpty()){
            int level = childrens.size();
            while(level > 0){
                level--;
                TreeNode current = childrens.poll();
                if(current == null) continue;
                if(current.left != null && (current.left.val == x))
                    parent1 = current.val;
                else if(current.right != null && (current.right.val == x))
                    parent1 = current.val;
                else if(current.left != null && (current.left.val == y))
                    parent2 = current.val;
                else if(current.right != null && (current.right.val == y))
                    parent2 = current.val;
                childrens.offer(current.left);
                childrens.offer(current.right);
            }
            if(parent1 == -1 && parent2 == -1) continue;
            
            if(parent1 == parent2 || parent1 == -1 || parent2 == -1) return false;
            return true;
        }
        return false;
    }
}