class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
     
        if(A == null || A.length < 1) return 0;
        Arrays.sort(A);
        for(int i = 0, counter = 0 ; counter < K ; counter++, i++){
            if(A[i] >= 0 && (K - counter) % 2 == 0)
                break;
            
            A[i] = -A[i];
            if(i + 1 < A.length && A[i] < A[i+1] && i > 1) i--;
        }
            
        
        long sum = 0;
        for(int i = 0 ; i < A.length ; i++){
            sum += A[i];
        }
        
        return (int) sum;
        
    }
}
