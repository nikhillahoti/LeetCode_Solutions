/*
Question ---> 

For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Write a function that determines whether two binary trees are flip equivalent.  The trees are given by root nodes root1 and root2.

 

Example 1:

Input: root1 = [1,2,3,4,5,6,null,null,null,7,8], root2 = [1,3,2,null,6,4,5,null,null,null,null,8,7]
Output: true
Explanation: We flipped at nodes with values 1, 3, and 5.
Flipped Trees Diagram

 

Note:

    Each tree will have at most 100 nodes.
    Each value in each tree will be a unique integer in the range [0, 99].

*/


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
    
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return insertEachLevel(root1, root2);
    }
    
    public boolean insertEachLevel(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        
        if(root1 == null || root2 == null) return false;
        
        if(root1.val != root2.val) return false;
        
        PriorityQueue<TreeNode> lst1 = new PriorityQueue<>((a,b) -> a.val - b.val);
        PriorityQueue<TreeNode> lst2 = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        if(root1.left != null) lst1.offer(root1.left);
        
        if(root1.right != null) lst1.offer(root1.right);
        
        if(root2.left != null) lst2.offer(root2.left);
        
        if(root2.right != null) lst2.offer(root2.right);
        
        if(lst1.size() != lst2.size()) return false;
        
        while(!lst1.isEmpty()){
            TreeNode f1 = lst1.poll();
            TreeNode f2 = lst2.poll();
            
            if(f1.val != f2.val || !insertEachLevel(f1, f2)) return false;
        }
        
        return true;
    }
    
    
}
