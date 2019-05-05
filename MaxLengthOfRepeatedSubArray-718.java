/*

Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

 

Note:

    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100


*/


class Solution {
    public int findLength(int[] A, int[] B) {
        
        if(A == null || A.length < 1 || B == null || B.length < 1) return 0;
        
	// At each step we save the number of matches if our the arrays were of that size.
	// For e.g. at the first step, we check to see if out B array was jusy of length 1 and element is 3,
	// how many matches we get with the A array. This result is then used for matching when checking the 
	// calculations for element 2 in array B, and so on
        
        int dp[][] = new int[A.length + 1][B.length + 1];
        int max = 0;
        for(int i = 1 ; i <= A.length ; i++){
            for(int j = 1 ; j <= B.length ; j++){
                if(A[i - 1] == B[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }
}
