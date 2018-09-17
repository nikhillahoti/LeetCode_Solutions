public class SurroundedRegions {

    public static void main(String[] args) {
        //char [][] board = new char[][] {{'X','X','X','X'},{'O','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        //char[][] board = new char[][] {{'O'}};
        char[][] board = new char[][] {{'O', 'X'}};
       
       
        SurroundedRegions region = new SurroundedRegions();
        region.solve(board);
       
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("");
        }
       
    }
   
    boolean [][] status;
   
    public void solve(char[][] board) {
       
        if( board == null || board.length == 0 || board[0].length == 0) return;
       
        status = new boolean[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                status[i][j] = false;
            }
        }
       
        for(int i = 0 ; i < board.length ; i++) {
            if(board[i][0] == 'O')
                checkSurroundings(i, 0, board);
        }
       
       
        for(int i = 0 ; i < board[0].length ; i++) {
            if(board[board.length - 1][i] == 'O')
                checkSurroundings(board.length - 1, i, board);
        }
       
        for(int i = 0 ; i < board.length ; i++) {
            if(board[i][board[0].length - 1] == 'O')
                checkSurroundings(i,  board[0].length - 1, board);
        }
       
        for(int i = 0 ; i < board[0].length ; i++) {
            if(board[0][i] == 'O')
                checkSurroundings(0, i, board);
        }
       
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(board[i][j] == 'O' && status[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }
    }
   
    public void checkSurroundings(int row, int col, char [][] cboard) {
        status[row][col] = true;
       
        if(row - 1 > -1 && status[row - 1][col] == false && cboard[row - 1][col] == 'O')
            checkSurroundings(row - 1, col, cboard);
       
        if(row + 1 < status.length && status[row + 1][col] == false && cboard[row + 1][col] == 'O')
            checkSurroundings(row + 1, col, cboard);
       
       
        if(col - 1 > -1 && status[row][col - 1] == false && cboard[row][col - 1] == 'O')
            checkSurroundings(row, col - 1, cboard);
       
        if(col + 1 < status[0].length && status[row][col + 1] == false && cboard[row][col + 1] == 'O')
            checkSurroundings(row, col + 1, cboard);   
    }
}
