def jump(nums):

    best = 0
    nextBest = 0
    jumps = 0
    for i in range(len(nums)-1):
        nextBest = nextBest if nextBest > (nums[i]) + i else nums[i] + i
        if i == best:
            jumps += 1
            best = nextBest

    return jumps

nums = [0]
nums = []
nums = [1,3,1,1,4]
print(jump(nums))
