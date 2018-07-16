

def binaryGap(N):
    str = "{0:b}".format(N)
    print(str)
    i = 0
    while i < len(str):
        if str[i] == '1':
            break
        i += 1

    index = i
    max = 0
    while i < len(str):
        if str[i] == '1':
            if (i - index) >= max:
                max = (i-index)
            index = i
        i += 1
    return max


print(binaryGap(2897))

