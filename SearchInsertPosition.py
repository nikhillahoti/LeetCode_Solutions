

def searchInsert(nums, target):
    right = len(nums) - 1
    left = 0

    if target < nums[0]: return 0
    if target > nums[right]: return right + 1

    while left <= right:
        mid = (int)((left + right) / 2)
        if target == nums[mid]: return mid
        if target > nums[mid]: left = mid + 1
        else: right = mid - 1

    return left


print(searchInsert([1,3,5,8, 12, 15], 14))
#print(searchInsert([1], 1))
