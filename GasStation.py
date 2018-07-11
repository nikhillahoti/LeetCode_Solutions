def canCompleteCircuit(gas, cost):

    position = 0
    prevsum = 0
    i = 0
    while i < len(gas):
        if gas[i] - cost[i] > 0:
            position = i
            break
        prevsum += (gas[i] - cost[i])
        i += 1

    if i == len(gas) and prevsum >= 0: return position

    sum = 0
    while i < len(gas):
        sum += gas[i] - cost[i]
        if sum <= 0 and i != len(gas) - 1:
            prevsum += sum
            position = -1
            sum = 0
        else:
            if position == -1:
                position = i
        i += 1

    if (sum + prevsum) >= 0 and position != -1: return position

    return -1


gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
#gas  = [2,3,4]
#cost = [3,4,3]
#gas  = [2]
#cost = [2]
#gas = [6,1,4,3,5]
#cost = [3,8,2,4,2]
gas = [3,1,1]
cost = [1,2,2]
print(canCompleteCircuit(gas, cost))



"""
    diff = []
    possible = []
    for i in range(len(gas)):
        subst = gas[i] - cost[i]
        if subst > 0:
            possible.append(i)
        diff.append(subst)

    if len(gas) == 1:
        if diff[0] >= 0: return 0

    for i in range(len(possible)):
        index = possible[i] + 1
        sum = diff[possible[i]]
        counter = 1
        while counter < len(gas):
            if index == len(gas):
                index = 0
            sum += diff[index]

            if sum < 0: break
            index += 1
            counter += 1
        if sum >= 0: return possible[i]

    return -1
"""