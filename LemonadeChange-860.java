class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills == null || bills.length < 1) return true;
        
        int []change = new int[3];
        int total = 0;
        for(int i = 0 ; i < bills.length ; i++){
            
            if(bills[i] == 5) {
                change[0]++;
                continue;
            }
            
            if(bills[i] == 10 && change[0] > 0) {
                change[1]++;
                change[0]--;
                continue;
            }
            if(bills[i] == 20){
                if(change[0] > 0 && change[1] > 0){
                    change[0]--; change[1]--;
                    continue;
                }
                if(change[0] > 2) {
                    change[0] -= 3;
                    continue;
                }
            }
            return false;
        }
        return true;
    }
}
