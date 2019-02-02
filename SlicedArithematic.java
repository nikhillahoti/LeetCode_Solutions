
// Problem N0. 413
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
     
        if(A == null || A.length < 3) return 0;
        
        int sliceCount = 0;
        int counter = A.length - 1;
        
        int sliced[] = new int[A.length];
        Arrays.fill(sliced, 0);
        
        for(int i = 1 ; i < counter ; i++){
            if(A[i] - A[i-1] == A[i+1] - A[i]) {
                sliceCount++;
                sliced[i] = 1;
            }
        }
        
        int dp[] = new int[A.length];
        Arrays.fill(dp, 0);
        
        for(int i = A.length - 2 ; i > -1 ; i--){
            if(sliced[i] == 1 && sliced[i + 1] == 1) {
                sliceCount += dp[i + 1] + 1;
                dp[i] = dp[i + 1] + 1;
            }
        }
        
        return sliceCount;
    }
}
