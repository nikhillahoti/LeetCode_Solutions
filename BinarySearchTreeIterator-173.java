/****

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

 

Note:

    next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
    You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.

****/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    // At each step, we check to see if the left subtree has any nodes, if yes, 
    //	1) firstly make the left subtree of the current node as null
    //  2) push the current node into the stack
    //  3) visit the left sub part of the current node
    Stack<TreeNode> stk = new Stack<>();
    public BSTIterator(TreeNode root) {
        if(root != null)
            stk.push(root);
    }
    
    /** @return the next smallest number */
    // For each call of the next method, we are sure to have the smallest node to be at the top of the stack, we then perform the above algorithm on the newly popped node
    public int next() {
        TreeNode root = stk.pop();
        if(root.left != null){
            TreeNode temp = root.left;
            root.left = null;
            stk.push(root);
            stk.push(temp);
            return next();
        }
        
        if(root.right != null){
            TreeNode temp = root.right;
            root.right = null;
            stk.push(temp);
        }
        return root.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stk.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
