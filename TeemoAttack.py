def findPoisonedDuration(timeSeries, duration):
    count = duration
    time = timeSeries[0] + duration - 1
    for i in range(1, len(timeSeries)):
        if time >= timeSeries[i]:
            count += (duration - (time - timeSeries[i]) - 1)
            time = time + (duration - (time - timeSeries[i]) - 1)
        else:
            time = timeSeries[i] + duration - 1
            count += duration
    return count

timeSeries = [1,4,5]
timeSeries = [1,4]
timeSeries = [1,3,5,7,9,11,13,15]
duration = 3

print(findPoisonedDuration(timeSeries, duration))