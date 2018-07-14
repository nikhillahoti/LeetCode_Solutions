def minimumTriangle(nums):
    if nums is None or len(nums) <= 0:
        return 0
    if len(nums) == 1:
        return nums[0][0]

    temp = nums[len(nums) - 1]
    for i in range(len(nums) - 2, -1, -1):
        interm = []

        if temp[0] <= temp[1]: interm.append(nums[i][0] + temp[0])
        else: interm.append(nums[i][0] + temp[1])

        for j in range(1,len(nums[i])):
            interm.append(nums[i][j] + min(temp[j], temp[j+1]))

        print("---")
        print(temp)
        print(interm)
        print("----")
        temp = interm

    return temp[0]

nums = [
    [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
nums = [
    [2],
    [3,4],
   [3,5,1],
  [4,1,8,1],
[4,1,8,3,1]
]
nums = [
    [2]
]
nums = [[2],
       [3,4],
      [6,5,2],
     [4,1,8,3]]


print(minimumTriangle(nums))
