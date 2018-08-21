

# Problem 217

def containsDuplicate(nums):
    dist = set(nums)
    if len(dist) == len(nums):
        return False
    return True

num = [1,2,3,4]
print(containsDuplicate(num))
