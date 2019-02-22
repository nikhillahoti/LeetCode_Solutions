
// Problem No. 925
class Solution {
    public boolean isLongPressedName(String name, String typed) {
    
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            while(j < typed.length() && typed.charAt(j) != name.charAt(i)){
                j++;
            }
            j++;
            i++;
        }
        if(i == name.length()) return true;  
        return false;
    }
}
