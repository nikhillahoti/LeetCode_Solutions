class Solution {
    public int lastRemaining(int n) {
        
        if(n == 1) return 1;
        
        int diff = 4, count = n / 2, num = n;
        if(num % 2 == 1)
            num -= 1;
        
        boolean right = true;
        while(count > 1){
            
            if(right){
                while(num - diff >= 0) 
                    num -= diff;    
                
                if(num - diff / 2 > 0)
                    num -= diff / 2;
                else 
                    num += diff / 2;
            }
            else {
                while(num + diff <= n)
                    num += diff;    
                
                if(diff / 2 + num >= n)
                    num -= diff / 2;   
                else 
                    num += diff / 2;            
            }                    
                        
            count /= 2;
            diff *= 2;
            right = !right;
        }
        
        return num;
    }
}
