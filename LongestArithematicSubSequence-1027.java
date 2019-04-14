class Solution {
    public int longestArithSeqLength(int[] A) {
        
        if(A == null || A.length < 1) return 0;
        
        HashMap<Integer, List<Integer>> indices = new HashMap<>();
        
        for(int i = A.length - 1 ; i > -1 ; i--){
            if(indices.containsKey(A[i])){
                List<Integer> indexes = indices.get(A[i]);
                indexes.add(0, i);
                indices.put(A[i], indexes);
            }
            else {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                indices.put(A[i], indexes);
            }
        }
        
        int count = Integer.MIN_VALUE;
        
        for(int i = 1; i < A.length ; i++){
            for(int j = 0 ; j < i ; j++){
                int curr = 2, lastIndex = i;
                int diff = A[i] - A[j];
                
                int nextElem = A[i] + diff;
                while(true)
                {
                    //System.out.println(nextElem);
                    if(indices.containsKey(nextElem)){
                        List<Integer> indexes = indices.get(nextElem);
                        int k = 0;
                        for(k = 0 ; k < indexes.size() ; k++){
                            if(indexes.get(k) > lastIndex){
                                lastIndex = indexes.get(k);
                                nextElem += diff;
                                curr++;
                                k = -1;
                                break;
                            }
                        }
                        if( k != -1) break;
                    }
                    else 
                        break;
                }
                count = Math.max(count, curr);
            }
        }
        
        return count;
    }
}
