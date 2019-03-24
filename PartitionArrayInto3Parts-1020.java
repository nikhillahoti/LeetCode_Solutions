 public boolean canThreePartsEqualSum(int[] A) {
        if(A == null || A.length < 1)   return false;
        int sum = 0;
        for(int num: A)
            sum += num;
        
        sum /= 3;
        int part = 0, count = 0;
        
        for(int num: A){
            part += num;
            if(part == sum){
                count++;
                part = 0;
            }
                
        }
        if(count == 3)
            return true;
        return false;
    }
