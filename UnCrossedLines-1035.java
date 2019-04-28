class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {

	// The idea is to check for the mapping for the first number in A with the entire B array, then for second number in A, then third and so on.
	// At each step we save the number of matches we get when there is a match and when we want to skip this number in A
        int [][] dp = new int[A.length + 1][B.length + 1];
        
        for(int i = 1; i <= A.length ; i++){
            for(int j = 1; j <= B.length ; j++){
                if(A[i - 1] == B[j - 1])
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[A.length][B.length];
    }
}
