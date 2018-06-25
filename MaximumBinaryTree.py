class TreeNode(object):
     def __init__(self, x):
         self.val = x
         self.left = None
         self.right = None

def constructMaximumBinaryTree(nums):
    if not len(nums) > 0:
        return None

    maxElem = 0
    counter = len(nums)
    for i in range(1, counter):
        if nums[i] > nums[maxElem]:
            maxElem = i

    root = TreeNode(nums[maxElem])

    root.left = constructMaximumBinaryTree(nums[:maxElem])
    root.right = constructMaximumBinaryTree(nums[maxElem+1:])

    return root

constructMaximumBinaryTree([3,2,1,6,0,5])