
def plusOne(nums):
    flag = True
    for i in range(len(nums) - 1, -1, -1):
        sum = nums[i] + 1
        if sum > 9: nums[i] = 0
        else:
            nums[i] = sum
            flag = False
            break

    if flag: nums = [1] + nums
    return nums

nums = [9,9,9,9,9]
#nums = [9]
print(plusOne(nums))