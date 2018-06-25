def scoreOfParentheses(S):
    stack = []
    value = 0
    for s in S:
        if s == "(":
            stack.append(s)
        else:
            ch = stack.pop()
            if ch == "(":
                if not stack: value += 1
                else: stack.append(1)
            else:
                temp = ch
                while stack:
                    ch = stack.pop()
                    if ch == "(": break
                    temp += ch
                temp *= 2
                if not stack: value += temp
                else: stack.append(temp)

    return value

print(scoreOfParentheses("(()(()))"))
print(scoreOfParentheses("(())"))
print(scoreOfParentheses("()(())"))
print(scoreOfParentheses("()(()())"))