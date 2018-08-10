# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def hasPathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: bool
        """
        
        if root == None: return False
        if root.left == None and root.right == None and root.val == sum: return True
            
        
        def checkSum(head, currsum):
            if head == None: return False
            if head.left == None and head.right == None and (currsum + head.val == sum): return True
            return checkSum(head.left, currsum + head.val) or checkSum(head.right, currsum + head.val)

        return checkSum(root.left, root.val) or checkSum(root.right, root.val)