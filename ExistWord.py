def exist(board, word):

    track = [[False for i in range(len(board[0]))] for j in range(len(board))]

    def checkNeighbour(track, index, i, j):

        if index == len(word):
            return True

        if i - 1 > -1 and word[index] == board[i-1][j] and track[i-1][j] == False:
            track[i-1][j] = True
            if checkNeighbour(track, index+1, i-1, j): return True

        if i + 1 < len(board) and word[index] == board[i+1][j] and track[i+1][j] == False:
            track[i+1][j] = True
            if checkNeighbour(track, index+1, i+1, j): return True

        if j - 1 > -1 and word[index] == board[i][j-1] and track[i][j-1] == False:
            track[i][j-1] = True
            if checkNeighbour(track, index+1, i, j-1): return True

        if j + 1 < len(board[0]) and word[index] == board[i][j+1] and track[i][j+1] == False:
            track[i][j+1] = True
            if checkNeighbour(track, index+1, i, j+1): return True

        return False

    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] == word[0]:
                track = [[False for i in range(len(board[0]))] for j in range(len(board))]
                track[i][j] = True
                if checkNeighbour(track, 1, i, j): return True

    return False


#board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']]
#board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
#board = [["a","a"]]
board = [["C","A","A"],["A","A","A"],["B","C","D"]]
word = "AAB"
print(exist(board, word))
