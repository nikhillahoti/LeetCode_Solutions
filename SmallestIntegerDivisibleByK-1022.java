class Solution {
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0) return -1;
        double  N = 1;
        int length = 0;
        boolean flag = false;
        while(length <= 1000000){ 
            length++;
            if(N % K == 0)
            {
                flag = true;
                break;
            }
            N = N % K;
            N = N * 10 + 1;
        }
        return flag ? length : -1;
    }
}
