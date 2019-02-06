
// Problem No. 888
class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        
        if(A == null || B == null || A.length < 1 || B.length < 1) return null;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int sumA = 0;
        for(int i = 0 ; i < A.length ; i++)
            sumA += A[i];
        
        int sumB = 0;
        for(int i = 0 ; i < B.length ; i++)
            sumB += B[i];
        
        int diff = (sumA - sumB) / 2;
        
        int i = 0,j = 0;
        while(i < A.length && j < B.length){
            int currDiff = A[i] - B[j];
            if(currDiff == diff){
                int result[] = new int[2];
                result[0] = A[i];
                result[1] = B[j];
                return result;
            }
            if(currDiff > diff) j++;
            else i++;
        }
        return null;
    }
}
