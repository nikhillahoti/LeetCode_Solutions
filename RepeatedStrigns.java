
// Problem No. 459 
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.isEmpty()) return true;
        
        for(int i = 1 ; i <= s.length() / 2 ; i++){
            if(s.length() % i == 0){
                String subStr = s.substring(0, i);
                StringBuilder str = new StringBuilder(subStr);
                int count = s.length() / i;
                while(count > 1){
                    str.append(subStr);
                    count--;
                }
                if(str.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
