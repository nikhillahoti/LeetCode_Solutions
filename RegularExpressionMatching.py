def isMatch(s, p):
    """
    :type s: str
    :type p: str
    :rtype: bool
    """

    index = 0
    counter = len(s)
    pCounter = 0
    patternCounter = len(p)

    while index < counter and pCounter < patternCounter:
        ch = ""
        # until the first character matches in the pattern loop the pattern
        flag = True
        while flag and pCounter < patternCounter and index < counter:
            if p[pCounter] == ".":
                ch = s[index]
                flag = False
            if s[index] == p[pCounter]:
                ch = s[index]
                flag = False
            index += 1
            pCounter += 1

        # after I found a pattern
        while pCounter < patternCounter and index < counter:
            if p[pCounter] == "*":
                pCounter += 1
                while index < counter and s[index] == ch:
                    index += 1
                if index == counter:
                    return True

            if pCounter < patternCounter and index < counter:
                if p[pCounter] == '.':
                    ch = s[index]

                if s[index] != p[pCounter]:
                    index = 0
                    break

                index += 1
                pCounter += 1
            else:
                return  True

    if index == counter:
        return  True

    return False

print(isMatch("aab", "a*ab"))