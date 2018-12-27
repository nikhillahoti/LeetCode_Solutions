class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        HashMap<Integer, Boolean> hash = new HashMap<>();
        while (true){
            int sum = 0;
            while(temp > 0){
                int rem = temp % 10;
                sum += rem * rem;
                temp /= 10;
            }    
            if (sum == 1) return true;
            
            if(hash.containsKey(sum)) return false;
            hash.put(sum, true);
            temp = sum;
        }
        //return false;
    }
}
