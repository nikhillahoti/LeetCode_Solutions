class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        if(A == null || B == null || A.length < 1 || B.length < 1 || A.length != B.length) return -1;
        HashMap<Integer, Integer> hashA = new HashMap<>();
        HashMap<Integer, Integer> hashB = new HashMap<>();
        HashMap<Integer, Integer> samePos = new HashMap<>();
        
        for(int i = 0 ; i < A.length ; i++){
            if(A[i] == B[i]){
                samePos.put(A[i], samePos.getOrDefault(A[i], 0) + 1);
                continue;
            }
            hashA.put(A[i], hashA.getOrDefault(A[i], 0) + 1);
            hashB.put(B[i], hashB.getOrDefault(B[i], 0) + 1);
        }
        
        int min = Integer.MAX_VALUE;
        boolean flag = false;
        for(Integer key : hashA.keySet()){
            if(hashA.getOrDefault(key,0) + hashB.getOrDefault(key, 0) + samePos.getOrDefault(key, 0) == A.length){
                int diff = Math.min(hashA.getOrDefault(key,0), hashB.getOrDefault(key,0));
                min = Math.min(min, diff);
                flag = true;
            }
        }
        
        for(Integer key : hashB.keySet()){
            if(hashA.getOrDefault(key,0) + hashB.getOrDefault(key, 0) + samePos.getOrDefault(key, 0) == A.length){
                int diff = Math.min(hashA.getOrDefault(key,0), hashB.getOrDefault(key,0));
                min = Math.min(min, diff);
                flag = true;
            }
        }
        
        for(Integer key : samePos.keySet()){
            if(hashA.getOrDefault(key,0) + hashB.getOrDefault(key, 0) + samePos.getOrDefault(key, 0) == A.length){
                int diff = Math.min(hashA.getOrDefault(key,0), hashB.getOrDefault(key,0));
                min = Math.min(min, diff);
                flag = true;
            }
        }
        
        if(!flag) return -1;
        return min;
    }
}
