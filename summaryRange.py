def summaryRanges(nums):
    result = []

    i = 0
    while i < len(nums):
        temp = nums[i]
        while i < (len(nums) - 1) and nums[i+1] == (nums[i] + 1): i += 1
        if nums[i] != temp:
            result.append(str(temp) + "->" + str(nums[i]))
        else: result.append(str(temp) + "")
        i += 1

    return result

nums = [0,1,2,4,5,7]
nums = [0,2,3,4, 6,7,9,11,12,13]
nums = [1, 4, 6, 8,9]
print(summaryRanges(nums))
