class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> output = new ArrayList<>();
        
        if(A == null || A.length < 1) return output;
        int value = 0;
        for(int num: A){
            value = value * 2;
            if(num == 1)
                value += 1;
            
            if(value % 5 == 0)
                output.add(true);
            else
                output.add(false);
            
            value = value % 5;
        }
        return output;
    }
}
