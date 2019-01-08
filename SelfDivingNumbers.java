// Problem No. 728
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> output = new ArrayList<>();
        right += 1;
        for(int i = left ; i < right ; i++){
            if(checkDivisibility(i)){
                output.add(i);
            }
        }
        return output;
    }
    
    public boolean checkDivisibility(int n){
        int temp = n;
        int rem = 0;
        while(temp > 0){
            rem = temp % 10;
            if(rem == 0) return false;
            if(n % rem !=  0) return false;
            temp /= 10;
        }
        return true;
    }
}
