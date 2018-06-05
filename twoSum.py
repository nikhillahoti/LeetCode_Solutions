def twoSum(nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    
 	d = {}
    for i,e in enumerate(nums):
        if e in d:
            return [d[e], i]
        d[target-e] = i

print(twoSum([1,2,3,4,5], 7))

