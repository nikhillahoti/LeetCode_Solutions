class Solution {
    public int calculate(String s) {
        Stack<Integer> valuesStk = new Stack<>();
        Stack<Character> OpStk = new Stack<>();
        
        HashMap<Character, Integer> hMap = new HashMap<>();
        hMap.put('+', 1);   hMap.put('-', 1);
        hMap.put('*', 2);   hMap.put('/', 2);
        
        int i = 0;
        while(i < s.length()){
            StringBuilder sb = new StringBuilder();
            while(i < s.length() && !hMap.containsKey(s.charAt(i))){
                if(s.charAt(i) == ' ') {
                    i++;
                    continue;
                }
                sb.append(s.charAt(i++));
            }
            
            int value = Integer.parseInt(sb.toString());
            valuesStk.push(value);
            
            if(i == s.length()) break;
            
            if(valuesStk.size() < 2)
                OpStk.push(s.charAt(i++));
            else {
                if(hMap.get(OpStk.peek()) >= hMap.get(s.charAt(i))){
                    while(OpStk.size() > 0 && hMap.get(OpStk.peek()) >= hMap.get(s.charAt(i))){
                        int value2 = valuesStk.pop();
                        int value1 = valuesStk.pop();
                        valuesStk.push(helper(value1, value2, OpStk.pop()));
                    }
                    OpStk.push(s.charAt(i++));    
                }
                else 
                    OpStk.push(s.charAt(i++));
            }
        }
        
        while(valuesStk.size() > 1){
            int value2 = valuesStk.pop();
            int value1 = valuesStk.pop();
            valuesStk.push(helper(value1, value2, OpStk.pop()));
        }
        
        return valuesStk.pop();
    }
    
    public int helper(int value1, int value2, char op){
        switch(op){
            case '+': return value1 + value2;
            case '-': return value1 - value2;
            case '*': return value1 * value2;
            case '/': return (int) value1 / value2;
        }
        return -1;
    }
}
