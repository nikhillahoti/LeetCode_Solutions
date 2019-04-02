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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode head = null;
        if(!(nums == null || nums.length < 1))
            head = partition(nums, 0, nums.length - 1);
        return head;                                                  
    }
    
    public TreeNode partition(int nums[], int startIndex, int endIndex){
        
        int mid = (startIndex + endIndex) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        
        if(mid != startIndex)
            node.left = partition(nums, startIndex, mid - 1);
        if(mid != endIndex)
            node.right = partition(nums, mid + 1, endIndex);
        
        return node;
    }
}
