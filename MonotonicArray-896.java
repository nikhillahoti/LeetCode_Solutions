class Solution {
    public boolean isMonotonic(int[] A) {
        if(A == null || A.length < 2) return true;
       
        boolean flag = true;
        int index = 0;
        while(index + 1 < A.length){
            index++;
            if(A[index] == A[index - 1]) continue;
            if(A[index] > A[index - 1]) flag = true;
            else flag = false;
            break;
        }
       
        if(index == A.length) return true;
       
        if(flag){
            while(index < A.length && A[index] >= A[index - 1])
                index++;
        }
        else {
            while(index < A.length && A[index] <= A[index - 1])
                index++;
        }
        if(index == A.length) return true;
        return false;
    }
}
