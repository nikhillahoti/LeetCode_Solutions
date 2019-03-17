class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        if(weights == null || weights.length < 1 || D == 0)
            return -1;
        if(D == 1)
        {
            int sum = 0;
            for(int num: weights)
                sum += num;
            return sum;
        }
        
        int max = weights[0];
        for(int num: weights)
            if(num > max)
                max = num;
        
        int sumTill [] = new int[D];
        int sumIndex [] = new int[D];
        
        int min = max;
        while(true){
            int index = 0;
            int track = 0;
            boolean flag = false;
            while(true){
                int sum = 0;
                for(; index < weights.length ;){
                    if(sum + weights[index] > min){
                        if(track >= D) {
                            flag = true;
                            break;
                        }
                        sumTill[track] = sum;
                        sumIndex[track] = index - 1;
                        track++;
                        sum = 0;
                        break;
                    }
                    sum += weights[index++];
                }
                if(sum > 0 && track == D) flag = true;
                if(flag || index == weights.length) break;
            }
            if(!flag) return min;
            min = sumTill[0] + weights[sumIndex[0] + 1];
            for(int i = 1 ; i < D ; i++){
                if(!(sumIndex[i] + 1 < weights.length)) break;
                min = Math.min(min, sumTill[i] + weights[sumIndex[i] + 1]);   
            }
        }
    }
}
