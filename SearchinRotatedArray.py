 def search(self, nums, target)
    
    type nums List[int]
    type target int
    rtype int
    
    
    start = 0
    end = len(nums) - 1

    while start  end
        mid = (start + end)  2
        if nums[mid]  nums[end] start = mid + 1
        else end = mid
    
    rot = start
    leng = len(nums)
    start = 0
    end = leng - 1

    while start = end
        mid = (start + end)  2
        realMid = (mid + rot) % leng
        if nums[realMid] == target return realMid
        if nums[realMid]  target end = mid - 1
        else start = mid + 1
    return -1

print(search([4,5,6,7,0,1,2]))
