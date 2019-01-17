
// Problem No. 551
class Solution {
    public boolean checkRecord(String s) {
        boolean flag = false;
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'A'){
                if(flag) return false;
                flag = true;
            }
            if(s.charAt(i) == 'L'){
                count++;
                if(count > 2) return false;
                continue;
            }
            count = 0;
        }
        return true;
    }
}
