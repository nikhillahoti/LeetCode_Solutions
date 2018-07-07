

def numDecodings(s):
    if s == "": return 0;
    length = len(s)

    dp = [0] * (length + 1)
    dp[length] = 1
    dp[length-1] = 0 if s[length-1] == "0" else 1

    for i in range(length - 2, -1, -1):
        if s[i] == "0": continue
        else: dp[i] = (dp[i+1] + dp[i+2]) if int(s[i] + s[i+1]) <= 26 else dp[i+1]

    return dp[0]



print(numDecodings("12012"))
