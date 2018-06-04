def longestValidParentheses(s):
    """
    :type s: str
    :rtype: int
    """
    
    i = 0
    counter = len(s)
    lst = []
    # keeping track of valid Parenthesis
    trkLst = [False] * counter

    while i < counter:
        if s[i] == "(":
            # Pushing the index of the opening bracket into the Stack
            lst.append(i)
        else:
            if len(lst) > 0:
                # Element in Stack
                trkLst[i] = True
                trkLst[lst.pop()] = True
            else:
                # Not valid elem is find, we clear the stack and check if the lenght of valid string found till now is
                # more than the maxcount found yet
                lst = []
        i = i + 1

    i = 0
    temp = 0
    maxcount = 0
    while i < counter:
        if trkLst[i]:
            temp = temp + 1
        else:
            if temp > maxcount:
                maxcount = temp
            temp = 0
        i = i + 1

    if temp > maxcount: maxcount = temp
    return  maxcount

print(str(longestValidParentheses("()(()()()")))