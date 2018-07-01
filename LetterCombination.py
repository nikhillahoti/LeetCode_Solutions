

def letterCombinations(digits):

    if len(digits) == 0: return []

    last = int(digits[-1:])
    digits = digits[:-1]
    arrString = letterCombinations(digits)

    if last == 1:
        return arrString

    count = 3
    if last == 9 or last == 7: count = 4

    offset = 0
    if last > 7: offset = 1

    arr = []
    flag = False
    if len(arrString) > 0:
        flag = True
    count = count + 1
    for i in range(1, count):
        temp = chr(96 + (last*3 - 6) + i + offset) + ""
        if flag:
            for j in range(len(arrString)):
                arr.append(arrString[j] + temp)
        else:
            arr.append(temp)
    return arr

digits = "23"
print(letterCombinations(digits))