
// Problem No. 258
class Solution {
    public int addDigits(int num) {
        
        if(num < 1) return 0;
        int temp = num;
        while(true){
            int sum = 0;
            while(temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
            temp = sum;
            if(temp < 10 && temp > 0){
                return temp;
            }
        }
        
    }
}
