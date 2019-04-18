class Solution {
    public int minSteps(int n) {
        
        int valueOnScreen = 1, valueInCopy = 1;
        int minSteps = 0;
        
        while(valueOnScreen < n){
            if(n % valueOnScreen == 0){
                minSteps += 2;
                valueInCopy = valueOnScreen;
                valueOnScreen += valueInCopy;
            }
            else {
                minSteps++;
                valueOnScreen += valueInCopy;
            }
        }
        
        return minSteps;
    }
}
