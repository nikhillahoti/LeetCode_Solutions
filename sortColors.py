

def sortColors(nums):
    length = len(nums)
    ptr0 = 0
    ptr2 = length - 1

    def swapIndex(index1, index2):
        temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp

    index = 0
    while index <= ptr2:
        if nums[index] == 0:
            swapIndex(index, ptr0)
            ptr0 += 1

        else:
            if nums[index] == 2:
                swapIndex(index, ptr2)
                ptr2 -= 1
                index -= 1

        """
        print(nums)
        print("ptr2->" + str(ptr2))
        print("ptr0->" + str(ptr0))
        print("index->" + str(index))
        print("-----")
        """
        index += 1
    print(nums)

sortColors([2, 0, 2, 1, 1, 0])
sortColors([2, 0, 1])
sortColors([2,2,0,1])
sortColors([2,2,1, 1])
