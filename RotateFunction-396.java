class Solution {
    public int maxRotateFunction(int[] A) {
        if(A == null || A.length < 1) return 0;
       
        int sum = 0;
        int count = 0;
        for(int i = 1 ; i < A.length ; i++){
            sum += A[i] * i;
            count += A[i];
        }
       
        int max = sum;
           
        int right = A.length - 1;
        int left = 0;
       
        while(right > 0){
           
            count -= A[right];
            sum -= A[right] * (A.length - 1);
           
            sum += count;
               
            count += A[left];
            sum += A[left];
           
            max = Math.max(max, sum);
           
            right--;
            left--;
            if(left < 0)
                left = A.length - 1;
        }
        return max;
    }
}
