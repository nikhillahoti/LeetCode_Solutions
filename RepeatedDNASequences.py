
def findRepeatedDnaSequences(s):
    length = len(s)
    if length < 10: return []

    length = length - 9

    dict = {}
    final = {}
    for i in range(0,length):
        substr = s[i:i+10]
        if substr in dict:
            final[substr] = True
        else:
            dict[substr] = 1

    return list(final.keys())

#findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
print(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"))

