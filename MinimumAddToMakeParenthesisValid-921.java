class Solution {
    public int minAddToMakeValid(String S) {
        
        if(S == null || S.length() < 1) return 0;
        
        int diff = 0, parenthesisNeeded = 0;
        for(char ch: S.toCharArray()){
            if(ch == '('){
                if(diff < 0){
                    parenthesisNeeded += (-1 * diff);
                    diff = 1;
                }
                else 
                    diff++;
            }
            else 
                diff--;
        }
        if(diff < 0)
            parenthesisNeeded += (-1 * diff);
        else if (diff > 0)
            parenthesisNeeded += diff;
        
        return parenthesisNeeded;
    }
}
