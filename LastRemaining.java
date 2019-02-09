
// Problem No. 390
class Solution {
    public int lastRemaining(int n) {
        
        if(n < 1) return 0;
        if(n == 1) return 1;
        
        int count = n/2;
        int diff = -4;
        
        int elem = n;
        if(elem % 2 == 1) elem--;
        n++;
        
        while(count > 1){
            
            while(elem + diff > 0 && (elem + diff) < n){
                elem += diff;
            }
            count /= 2;
            if(diff < 0) {
            	if(elem - ((diff / 2) * -1) > 0)
                	elem -= (diff / 2) * -1;	
                else 
                	elem += (diff / 2) * -1;                	
            }
            else {
            	if(elem + ((diff / 2)) < n)
                	elem += (diff / 2);	
                else 
                	elem -= (diff / 2);
            }        
            diff *= -2;
                  
        }
        return elem;
    }
}
