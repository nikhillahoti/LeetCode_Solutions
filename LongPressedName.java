
// Problem No. 925
class Solution {
    public boolean isLongPressedName(String name, String typed) {
    
        if(name.length() < 1 && typed.length() < 1) return true;
        
        if(name.length() < 1 && typed.length() > 1) return false;
        if(typed.length() < 1 && name.length() > 1) return false;
        
        int i = 0;
        int j = 0;
        while(i < name.length() && j < typed.length()){
            if(name.charAt(i) != typed.charAt(j)) return false;
            i++;
            j++;
            
            if(i < name.length() && name.charAt(i) != name.charAt(i-1)){
                while(j < typed.length() && typed.charAt(j) == typed.charAt(j-1)){
                    j++;                   
                }
            }
        }
        if(i == name.length()) return true;  
        return false;
    }
}
