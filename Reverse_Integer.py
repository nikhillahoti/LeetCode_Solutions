
def reverse(x):
    if x > 2147483647:
        return 0
    temp = x
    flag = 0
    if(temp<0):
        flag = 1
        temp = temp * -1
    value = 0
    while (temp > 0):
        remainder = temp % 10
        value = value * 10 + remainder
        temp = temp / 10
    return  (value if not flag else value * -1)

print(reverse(1534236469))