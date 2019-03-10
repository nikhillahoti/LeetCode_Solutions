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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        if(preorder == null || preorder.length < 1) return root; 
        this.preorder = preorder;
        
        visited = new int[preorder.length];
        root = new TreeNode(preorder[0]);
        createLeft(root, 1, root.val, root.val);
        createRight(root, 1, root.val, Integer.MAX_VALUE);
        
        return root;
    }
    
    int [] preorder = null;
    int [] visited = null;
    
    public void createLeft(TreeNode root, int index, int left, int parent){
        for(int i = index ; i < preorder.length ; i++){
            if(preorder[i] < left && visited[i] == 0){
                TreeNode lef = new TreeNode(preorder[i]);
                root.left = lef;
                visited[i] = 1;
                createLeft(lef, i + 1, lef.val, root.val);
                createRight(lef, i + 1, lef.val, root.val);
                break;
            }
        }
    }
    
    public void createRight(TreeNode root, int index, int right, int parent){
        for(int i = index ; i < preorder.length ; i++){
            if(preorder[i] > right && visited[i] == 0 && preorder[i] < parent){
                TreeNode lef = new TreeNode(preorder[i]);
                root.right = lef;
                visited[i] = 1;
                createLeft(lef, i + 1, lef.val, parent);
                createRight(lef, i + 1, lef.val, parent);
                break;
            }
        }
    }
}
