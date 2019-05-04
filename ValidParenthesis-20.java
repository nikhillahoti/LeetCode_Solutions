class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        
        if(s == null || s.length() < 1) return true;
        if(s.length() % 2 == 1) return false;
        
        for(char ch: s.toCharArray()){
            if(ch == ']')
            {
                if(stk.isEmpty() || stk.peek() != '[') return false;
                stk.pop();
            }
            else if(ch == '}')
            {
                if(stk.isEmpty() || stk.peek() != '{') return false;
                stk.pop();
            }
            else if(ch == ')')
            {
                if(stk.isEmpty() || stk.peek() != '(') return false;
                stk.pop();
            }
            else 
                stk.push(ch);
        }
        if(stk.isEmpty())
            return true;        
        return false;        
    }
}
