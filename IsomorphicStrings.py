# Problem 204

def isIsomorphic(s, t):

    if len(s) != len(t): return False

    dict = {}
    val = set()
    nStr = ""
    for i in range(0, len(s)):
        ch = s[i]

        if ch in dict:
            ch = dict[ch]
        else:
            if ch == t[i]:
                dict[ch] = ch
            else:
                dict[ch] = t[i]
                ch = t[i]
        nStr += ch

    if len(set(dict.values())) != len(dict): return False

    if nStr == t: return  True
    return False


print(isIsomorphic("bty", "bat"))
