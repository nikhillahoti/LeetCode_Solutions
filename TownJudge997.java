class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust == null) return -1;
        if(N == 1 && trust.length < 1) return 1;
        
        if(trust.length < 1) return -1;
        
        HashSet<Integer> notTownJudge = new HashSet<>();
        HashMap<Integer, Integer> townJudge = new HashMap<>();
        
        for(int i = 0 ; i < trust.length ; i++){
            notTownJudge.add(trust[i][0]);
            if(townJudge.containsKey(trust[i][0])) {
                townJudge.remove(trust[i][0]);   
            }
            if(notTownJudge.contains(trust[i][1])) {
                if(townJudge.containsKey(trust[i][1])) townJudge.remove(trust[i][1]);
                continue;
            }
            if(!notTownJudge.contains(trust[i][1])){
                if(townJudge.containsKey(trust[i][1])){
                    townJudge.put(trust[i][1], townJudge.get(trust[i][1]) + 1);
                }
                else {
                    townJudge.put(trust[i][1], 1);
                }
            }
            
        }
        
        if(townJudge.size() > 1) return -1;
        for(Integer key: townJudge.keySet()){
            if(townJudge.get(key) == N - 1) 
                return key;
        }
        return -1;
    }
}
