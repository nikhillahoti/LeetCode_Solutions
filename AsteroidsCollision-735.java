class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        List<Integer> output = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();
        
        for(int num: asteroids){
            if(num > 0)
                stk.push(num);
            else {
                while(!stk.isEmpty() && stk.peek() < (num * -1))
                    stk.pop();
                
                if(!stk.isEmpty()){
                    if(stk.peek() == (num * -1))
                        stk.pop(); 
                }
                else
                    output.add(num);
            }
        }
        
        Stack<Integer> temp = new Stack<>();
        while(!stk.isEmpty())
            temp.push(stk.pop());
        
        while(!temp.isEmpty())
            output.add(temp.pop());
        
        int result[] = new int[output.size()];
        for(int i = 0 ;i < output.size(); i++)
            result[i] = output.get(i);
        
        return result;
    }
}
