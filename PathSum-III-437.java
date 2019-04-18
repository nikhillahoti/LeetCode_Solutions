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
    public int pathSum(TreeNode root, int sum) {
        postOrder(root, new HashMap<Integer, Integer>(), sum);
        return totalPathSums;
    }
    
    int totalPathSums = 0;
    public void postOrder(TreeNode root, HashMap<Integer, Integer> pathsum, int sum){
        if(root == null) return;
        
        if(root.val == sum)
            totalPathSums++;
        
        HashMap<Integer, Integer> sumCount = new HashMap<>();
        for(Integer key: pathsum.keySet()){
            
            if(key + root.val == sum)
                totalPathSums += pathsum.get(key);
            
            sumCount.put(key + root.val, pathsum.get(key));            
        }
        sumCount.put(root.val, sumCount.getOrDefault(root.val, 0) + 1);
        
        postOrder(root.left, sumCount, sum);
        postOrder(root.right, sumCount, sum);
    }
}
