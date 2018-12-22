class Solution {

    // The basic idea is to check if the maxSum is constituted of the currentNode and if yes, which part of the subtree

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int value = getNodeSum(root);
        return Math.max(maxSum, value);        
    }
    

    public int getNodeSum(TreeNode currentNode){

    if (currentNode.left == null && currentNode.right == null){
        if(currentNode.val > maxSum) maxSum = currentNode.val;
        return currentNode.val;
    }    

    int leftSubTreeSum = 0;
    if(currentNode.left != null)
        leftSubTreeSum = getNodeSum(currentNode.left);
    
    int rightSubTreeSum = 0;
    if(currentNode.right != null)    
        rightSubTreeSum = getNodeSum(currentNode.right);

    maxSum = Math.max(maxSum, currentNode.val + leftSubTreeSum + rightSubTreeSum);
    maxSum = Math.max(maxSum, currentNode.val);
    maxSum = Math.max(maxSum, currentNode.val + leftSubTreeSum);
    maxSum = Math.max(maxSum, currentNode.val + rightSubTreeSum);
        
    return Math.max(Math.max(currentNode.val + leftSubTreeSum, currentNode.val + rightSubTreeSum), currentNode.val);
    }

}