

def removeDuplicate(nums):
    def BinarySearch(target, right):
        left = 0
        while left <= right:
            mid = (int)((left + right) / 2)
            if nums[mid] == target: return True
            if nums[mid] > target: right = mid - 1
            else: left = mid + 1
        return False

    index = 1
    for i in range(len(nums)):
        if not BinarySearch(nums[i], index - 1):
            nums[index] = nums[i]
            index += 1

    nums = nums[0:index]
    return len(nums)

nums = [1,1,2,2,4,5,6]
print(removeDuplicate(nums))
