class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
       
        List<Integer> output = new ArrayList<>();
        
        if(x == 1 && y == 1){
            if(bound >= 2)
                output.add(2);
            return output;
        }
        
        if(x == 1 || y == 1){
            int num1 = Math.min(x, y), num2 = Math.max(x, y);
            int index = 0;
            while((int)Math.pow(num2, index) + 1 <= bound){
                output.add((int)Math.pow(num2, index) + 1);
                index++;
            }
            return output;
        }
        else 
        {
            HashSet<Integer> hash = new HashSet<>();
            int i = 0;
            while((int)Math.pow(x, i) < bound){
                int j = 0;
                while((int)Math.pow(y, j) < bound){
                    if((int)Math.pow(x, i) + (int)Math.pow(y, j) > bound) break;
                    hash.add((int)Math.pow(x, i) + (int)Math.pow(y, j));
                    j++;
                }
                i++;
            }
            return new ArrayList<>(hash);
        }
        
    }
}
