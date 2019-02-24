class Solution {
    public void setZeroes(int[][] matrix) {
        
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) return;
        
        boolean flagRow = false;
        boolean flagCol = false;
        if(matrix[0][0] == 0) {
            flagRow = true;
            flagCol = true;
        }
        
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if(i == 0)
                        flagRow = true;
                    
                    if(j == 0)
                        flagCol = true;
                }
            }
        }
        
        for(int j = 1 ; j < matrix[0].length ; j++){
            if(matrix[0][j] == 0){
                for(int i = 1 ; i < matrix.length ; i++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 1 ; i < matrix.length ; i++){
            if(matrix[i][0] == 0){
                for(int j = 1 ; j < matrix[0].length ; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        System.out.println(flagRow);
        System.out.println(flagCol);
        
        if(flagRow){
            for(int i = 0 ; i < matrix[0].length ; i++){
                matrix[0][i] = 0;
            }   
        }
        if(flagCol){
            for(int i = 0 ; i < matrix.length ; i++){
                matrix[i][0] = 0;
            }   
        }        
    }
}
