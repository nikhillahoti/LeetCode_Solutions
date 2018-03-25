def maxIncreaseKeepingSkyline(grid):

    if grid is None:
        return 0

    gridCopy = [[ grid[row][col] for row in range(0,len(grid)) ] for col in range(0,len(grid[0]))]

    top = [0] * len(gridCopy)
    left = [0] * len(grid)

    for i in range(0, len(grid)):
        left[i] = max(grid[i])

    for i in range(0, len(gridCopy)):
        top[i] = max(gridCopy[i])

    count = 0
    for i in range(0, len(grid)):
        highLeft = left[i]
        for j in range(0,len(grid[0])):
            highTop = top[j]

            maxHere = highLeft if highLeft < highTop else highTop
            #  print(str(i) + " " + str(j) + ":" + str(highLeft) + ":" + str(highTop))
            if grid[i][j] < maxHere:
                count = count + (maxHere - grid[i][j])

    return count

grid = [[3, 0, 8, 4], [2, 4, 5, 7], [9, 2, 6, 3], [0, 3, 1, 0]]
print(maxIncreaseKeepingSkyline(grid))
