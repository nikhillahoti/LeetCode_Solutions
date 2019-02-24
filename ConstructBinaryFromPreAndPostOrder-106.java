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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || postorder == null) return null;
        
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length - 1, inorder.length - 1);
    }
    
    int inorder[]; 
    int postorder[]; 
    public TreeNode build(int startIndex, int endIndex, int postIndex){
        if(startIndex == endIndex) 
            return new TreeNode(inorder[startIndex]);
        
        HashMap<Integer, Integer> inOrderIndex = new HashMap<>();
        for(int i = startIndex ; i <= endIndex ; i++)
            inOrderIndex.put(inorder[i], i);
        
        while(postIndex > -1){
            if(inOrderIndex.containsKey(postorder[postIndex])) {
                int index = inOrderIndex.get(postorder[postIndex]);
                TreeNode node = new TreeNode(inorder[index]);
                if(index != startIndex)
                    node.left = build(startIndex, index - 1, postIndex);
                
                if(index != endIndex)
                    node.right = build(index + 1, endIndex, postIndex);
                
                return node;
            }
            postIndex--;
        }
        return null;
    }
}
