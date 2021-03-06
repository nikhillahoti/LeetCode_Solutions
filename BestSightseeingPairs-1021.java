class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        if(A == null || A.length < 1) return 0;
        
        int maxIndex = A.length - 1;
        int maxValue = Integer.MIN_VALUE;
        for(int i = A.length - 2 ; i > -1 ; i--){
            maxValue = Math.max(A[i] + A[maxIndex] + i - maxIndex, maxValue);
            if(A[i] + maxIndex - i > A[maxIndex])
                maxIndex = i;
        }
        
        return maxValue;
    }
}
