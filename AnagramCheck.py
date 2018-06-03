
def isAnagram(s, t):
    d1 = {}
    d2 = {}
    for i in range(0, len(s)):
        d1[s[i]] = d1.get(s[i],0) + 1
    for i in range(0, len(t)):
        d2[t[i]] = d2.get(t[i],0) + 1
    return d1 == d2

print(isAnagram("cinema","iceman"))