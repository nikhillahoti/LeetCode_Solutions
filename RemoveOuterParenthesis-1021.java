class Solution {
    public String removeOuterParentheses(String S) {
        
        if(S == null || S.length() < 1) return "";
        StringBuilder sb = new StringBuilder();
        
        int i = 0, counter = S.length() - 1, openBraces = 0;
        while( i <= counter){
            if(S.charAt(i) == '('){
                openBraces++;
                if(openBraces > 1)
                    sb.append(S.charAt(i));
            }
            else {
                openBraces--;
                if(openBraces >= 1)
                    sb.append(S.charAt(i));
            }
                
            i++;
        }
        return sb.toString();
    }
}
