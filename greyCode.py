
def grayCode(n):

    if n == 0: return [0]

    greyList = ["0", "1"]

    for i in range(1, n):
        temp = []
        for j in range(len(greyList)): temp.append("0" + greyList[j])
        for j in range(len(greyList) - 1, -1, -1): temp.append("1" + greyList[j])
        greyList = temp

    print(greyList)
    greyNum = []
    for str in greyList:
        greyNum.append(int(str, 2))

    return greyNum

print(grayCode(3))
