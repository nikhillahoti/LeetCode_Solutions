
def removeElement(nums, val):
    index = len(nums) - 1

    i = 0
    while i <= index:
        if nums[i] == val:
            temp = nums[i]
            nums[i] = nums[index]
            nums[index] = temp
            index -= 1
            continue
        i += 1

    return i

nums = [3,2,2,3]
nums = [1,4,2,5]
val = 3
nums = None
print(removeElement(nums, val))
