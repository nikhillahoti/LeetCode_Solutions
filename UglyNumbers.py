
# Problem Number : 263 LeetCode

def isUgly(num):

    if num <= 0: return False

    div = 2
    while num > 1:
        if num % div == 0:
            num = num / div
        else:
            if div == 2:
                div = 3
            else:
                if div == 3:
                    div = 5
                else:
                    return False
    return True



num = 1
print(isUgly(num))