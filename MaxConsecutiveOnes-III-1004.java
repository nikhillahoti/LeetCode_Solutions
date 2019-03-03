class Solution {
    public int longestOnes(int[] A, int K) {
        
        if(A == null || A.length < 1) return 0;
        
        List<Integer> lst = new ArrayList<>();
        int OneCount = 0;
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] == 0){
                if(OneCount > 0)
                    lst.add(OneCount);
                lst.add(0);           
                OneCount = 0;
            }
            else {
                OneCount++;
            }
        } 
        
        if(OneCount > 0) lst.add(OneCount);
        OneCount = 0;
        
        if(K == 0){
            int maxC = lst.get(0);
            for(int i = 0 ; i < lst.size() ; i++){
                if(lst.get(i) == 0) continue;
                maxC = Math.max(maxC, lst.get(i));
            }
            return maxC;
        }
        
        int sum = 0;
        int left = 0;
        int zeroCount = 0;
        int i = 0;
        int maxOnes = Integer.MIN_VALUE;
        
        while(i < lst.size()){
            while(i < lst.size() && zeroCount <= K)   {
                if(zeroCount > K) break;
                if(lst.get(i) == 0){
                    zeroCount++;
                }
                else{
                    sum += lst.get(i);
                }
                i++;
            }
            
            if(zeroCount > K){
                i--;
                zeroCount--;
            } 
            
            maxOnes = Math.max(maxOnes, sum + zeroCount);
            boolean flag = false;
            while(left < i && zeroCount >= K){
                //if(zeroCount < 1) break;
                if(lst.get(left) == 0){
                    zeroCount--;
                }
                else {
                    if(zeroCount < K) break;
                    sum -= lst.get(left);
                }
                left++;
            }
        }
        
        return maxOnes;
    }
}

