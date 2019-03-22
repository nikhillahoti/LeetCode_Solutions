public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int a = 0;
        while(a < 32){
            if((n & 1) == 1)
                count++;
            n = n >>> 1;
            a++;
        }
        return count;    
    }
}
