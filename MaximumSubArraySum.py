

def maxSubArray(nums):

    if nums == [] or len(nums) < 0: return 0

    sum = nums[0] if nums[0] > 0 else 0
    max = nums[0]
    for i in range(1, len(nums)):
        sum += nums[i]
        if sum > max: max = sum

        if sum < 0: sum = 0

    return max

nums = [-2,1,-3,4,1,2,1,-3,4]
nums = [-2,1]
print(maxSubArray(nums))
