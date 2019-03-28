class Solution {
    public int arrangeCoins(int n) {
        int i = 1, staircase = 0;
        while(n - i >= 0){
            staircase++;
            n -= i;
            i++;
        }
        return staircase;
    }
}
