def checkforIsland(x, y):
    if x-1 > -1 and grid[x-1][y] == "1":
        grid[x-1][y] = "2"
        checkforIsland(x-1,y)
    if x+1 < len(grid) and grid[x+1][y] == "1":
        grid[x+1][y] = "2"
        checkforIsland(x+1, y)
    if y-1 > -1 and grid[x][y-1] == "1":
        grid[x][y-1] = "2"
        checkforIsland(x, y-1)
    if y+1 < len(grid[0]) and grid[x][y+1] == "1":
        grid[x][y+1] = "2"
        checkforIsland(x, y+1)

count = 0
for i in range(len(grid)):
    for j in range(len(grid[0])):
        if grid[i][j] == "1":
            checkforIsland(i,j)
            count += 1
return count
