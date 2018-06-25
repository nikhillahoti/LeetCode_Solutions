def numJewelsInStones(J, S):
    jewels = set(J)

    count = 0
    for ch in S:
        if ch in jewels:
            count += 1
    return count

print(numJewelsInStones("aA", "aAAbbbb"))