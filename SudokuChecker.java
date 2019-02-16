
// Problem No. 36
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for(int i = 0 ; i < 9 ; i++)
            rowLst.add(new HashSet<>());
        
        for(int i = 0 ; i < 9 ; i++)
            colLst.add(new HashSet<>());
        
        
        for(int i = 0 ; i < 9 ; i++){   
            for(int j = 0 ; j < 9 ; j++){
                if(board[i][j] == '.') continue;
                
                if(rowLst.get(i).contains(board[i][j])) return false;
                HashSet<Character> rr = rowLst.get(i);
                rr.add(board[i][j]);
                rowLst.set(i, rr);
                
                if(colLst.get(j).contains(board[i][j])) return false;
                HashSet<Character> cc = colLst.get(j);
                cc.add(board[i][j]);
                colLst.set(j, cc);
            }
        }
        
        this.board = board;
        for(int i = 0 ; i < 9 ; i += 3){
            for(int j = 0 ; j < 9 ; j += 3){
                if(!checkMatrix(i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    char[][] board;
    List<HashSet<Character>> rowLst = new ArrayList<>();
    List<HashSet<Character>> colLst = new ArrayList<>();
    
    public boolean checkMatrix(int row, int col){
        int rowboundary = row + 3;
        int colboundary = col + 3;
        
        HashSet<Character> hash = new HashSet<>();
        
        for(int i = row ; i < rowboundary ; i++){
            for(int j = col ; j < colboundary ; j++){
                if(board[i][j] == '.') continue;
                if(hash.contains(board[i][j])) return false; 
                hash.add(board[i][j]);
            }
        }
        return true;
    }


}
