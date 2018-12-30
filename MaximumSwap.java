
// Problem Number ---> 970
class Solution {
    public int maximumSwap(int num) {
        ArrayList<Integer> individualNumber = new ArrayList<>();
        int temp = num;
        while(temp > 0){
            individualNumber.add(temp % 10);
            temp /= 10;
        }
        
        int max[] = new int[individualNumber.size()];
        int pos[] = new int[individualNumber.size()];        
        
        max[0] = individualNumber.get(0);
        pos[0] = 0;
        for(int i = 1; i < max.length ; i++){
            if(individualNumber.get(i) > max[i-1]){
                max[i] = individualNumber.get(i);
                pos[i] = i;
            }
            else{
                max[i] = max[i-1];
                pos[i] = pos[i-1];
            }
        }
        
        for(int i = 0 ; i < max.length ; i++){
            System.out.print("\t" + pos[i]);
        }
        System.out.print("\n");        
        
        for(int i = max.length - 1; i > 0 ; i--){
            if(pos[i] == i) continue;
            
            if(max[i] == individualNumber.get(i)) continue;
            
            temp = individualNumber.get(i);
            individualNumber.set(i, individualNumber.get(pos[i]));
            individualNumber.set(pos[i], temp);
            break;        
        }
    
        for(int i = 0 ; i < max.length ; i++){
            System.out.print("\t" + individualNumber.get(i));
        }

        
        temp = 0;
        for(int i = max.length - 1 ; i > -1 ; i--){
            temp = (individualNumber.get(i) + 10 * temp);
        }
        return temp;
        
    }
}
