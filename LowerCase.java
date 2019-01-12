
// Problem No. 709
class Solution {
    public String toLowerCase(String str) {
        
        if(str.length() < 1 || str.isEmpty()) return str;
        
        StringBuilder lowerCase = new StringBuilder(str);
        int index = 0;
        for(char ch: str.toCharArray()){
            if(ch > 64 && ch < 91){
                ch += 32;
                lowerCase.setCharAt(index, ch);
            }
            index++;
        }
        return lowerCase.toString();
    }
}
