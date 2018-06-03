
def lengthOfLongestSubstring(s):
    if s is None or len(s) < 1:
        return 0

    index = 0
    arr = [s[0]]
    arrcounter = 0
    counter = len(s)
    count = 0

    while index < counter:
        if s[index] in arr:
            if arrcounter > count:
                count = arrcounter

            arr = arr[arr.index(s[index]) + 1: len(arr)]
            arr.append(s[index])
            arrcounter = len(arr)
        else:
            arr.append(s[index])
            arrcounter += 1

        index += 1

    if len(arr) > count:
        count = len(arr)

    return count



print(lengthOfLongestSubstring("abcdaef"))