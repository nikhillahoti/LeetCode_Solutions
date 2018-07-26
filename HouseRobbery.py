

def rob(nums):

    if len(nums) <= 0: return 0

    dp = [0] * len(nums)
    dp[0] = nums[0]

    if len(nums) > 1:
        dp[1] = nums[1] if nums[1] > nums[0] else nums[0]

    for i in range(2,len(nums)):
        dp[i] = dp[i-1] if dp[i-1] >= (nums[i] + dp[i-2]) else (nums[i] + dp[i-2])

    return dp[len(nums) - 1]

#nums = [1,2,3,1]
#nums = [7,1,2,9]
#nums = [2,4]
#nums = [1,3,1]
nums = [183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211]
print(rob(nums))
