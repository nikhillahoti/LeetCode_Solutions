def numberOfLines(widths, S):

    if S is None: return [0,0]

    lineCount = 0
    Max = 100
    value = Max
    for i in range(0, len(S)):
        value = value - widths[ord(S[i]) - 97]
        if not(value >= 0):
            value = Max - widths[ord(S[i]) - 97]
            lineCount = lineCount + 1

    return [lineCount + 1, Max - value]

'''widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10]
S = "abcdefghijklmnopqrstuvwxyz"
print(numberOfLines(widths, S))
'''