
// problem No 999
class Solution {
    public int numRookCaptures(char[][] board) {
        if(board == null || board.length < 1) return 0;
        
        int row = 0, col = 0;
        for(row = 0 ; row < 8 ; row++){
            boolean flag = false;
            for(col = 0 ; col < 8 ; col++){
                if(board[row][col] == 'R'){
                    flag = true;
                    break;   
                }
            }
            if(flag) break;
        }
        
        System.out.println(row);
        System.out.println(col);
        
        int temp = row - 1;
        int pawnCount = 0;
        while(temp > -1){
            if(board[temp][col] == 'p'){
                pawnCount++;
                break;
            }
            if(board[temp][col] == 'B') break;
            temp--;
        }
        
        temp = row + 1;
        while(temp < 8){
            if(board[temp][col] == 'p'){
                pawnCount++;
                break;
            }
            if(board[temp][col] == 'B') break;
            temp++;
        }
        
        temp = col - 1;
        while(temp > -1){
            if(board[row][temp] == 'p'){
                pawnCount++;
                break;
            }
            if(board[row][temp] == 'B') break;
            temp--;
        }
        
        temp = col + 1;
        while(temp < 8){
            if(board[row][temp] == 'p'){
                pawnCount++;
                break;
            }
            if(board[row][temp] == 'B') break;
            temp++;
        }
        
        return pawnCount;
        
    }
}
