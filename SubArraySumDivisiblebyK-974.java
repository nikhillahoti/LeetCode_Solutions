class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int mod[] = new int[K];
        int sum = 0;
        int count = 0;
        mod[0] = 1;
        for(int num: A){
            sum += num;
            int m = sum % K;
            if(m < 0) m += K;
            count += mod[m];
            mod[m]++;
        }
       
        return count;
    }
}
