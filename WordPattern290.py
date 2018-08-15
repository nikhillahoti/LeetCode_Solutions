
# Problem Number: 290

def wordPattern(pattern, str):
    dict = {}
    dictRev = {}
    output = ""
    lstStr = str.split(" ")

    if len(pattern) != len(lstStr): return False

    for i in range(len(pattern)):
        if not pattern[i] in dict:
            if lstStr[i] in dictRev: return False
            dict[pattern[i]] = lstStr[i]
            dictRev[lstStr[i]] = pattern[i]
        output = output + " " + dict[pattern[i]]

    if output[1:] ==  str: return True
    return False





pattern = "abc"
str = "b c a"
print(wordPattern(pattern, str))

