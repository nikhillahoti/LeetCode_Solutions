

def longestCommonPrefix(strs):

    if strs is None or len(strs) < 0: return ""

    maxLength = len(strs[0])
    prevString = strs[0]
    for i in range(1, len(strs)):
        j = 0
        while j < maxLength and j < len(strs[i]) and j < len(prevString):
            if prevString[j] != strs[i][j]:
                break
            j += 1
        maxLength = j
        prevString = strs[i]
        if maxLength <= 0: return ""


    return strs[0][:maxLength]

strs = ["flower","flow","flight"]
#strs = ["flower","flow","light"]
#strs = ["aaa","aa","aaa"]
strs = ["a","aa","aaa", ""]
print(longestCommonPrefix(strs))
