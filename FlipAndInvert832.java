// Problem: 832
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        int [][]result = {{}};
        if (A.length <= 0) return result;
        
        result = new int[A.length][A[0].length];
        for (int i = 0 ; i < A.length ; i++){
            for (int j = A[i].length - 1 ; j > -1 ; j--){
                if(A[i][j] == 0){
                    result[i][A[i].length - 1 - j] = 1;
                }
                else{
                    result[i][A[i].length - 1 - j] = 0;
                }
            }
        }
        
        return result;
    }
}
