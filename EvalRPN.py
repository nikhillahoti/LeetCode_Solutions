def evalRPN(tokens):
    stack = []
    for i in range(len(tokens)):
        if tokens[i] == '+' or  tokens[i] == '*' or  tokens[i] == '-' or  tokens[i] == '/':
            num2 = stack.pop()
            num1 = stack.pop()
            if tokens[i] == '+': stack.append(num1 + num2)
            else:
                if tokens[i] == '-': stack.append(num1 - num2)
                else:
                    if tokens[i] == '*': stack.append(num1 * num2)
                    else:
                        if tokens[i] == '/':
                            stack.append((int) (float(num1) / num2))
        else:
            stack.append((int) (tokens[i]))
    return stack.pop()


tokens = ["2", "1", "+", "3", "*"]
tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
print(evalRPN(tokens))
