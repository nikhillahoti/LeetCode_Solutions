

def rob(nums):
    def getMax(index, sum):
        if index >= len(nums): return sum
        max1 = getMax(index + 2, sum + nums[index])
        max2 = getMax(index+1, sum)
        return max1 if max1 > max2 else max2

    return getMax(0, 0)

nums = [1,2,3,1]
nums = [7,1,2,9]
nums = [2,4]
nums = [1,3,1]
nums = [183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211]
print(rob(nums))
