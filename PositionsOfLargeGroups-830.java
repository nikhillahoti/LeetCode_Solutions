class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
    
        if(S == null || S.length() < 1) return result;
        
        char ch = S.charAt(0);
        int startIndex = 0;
        int count = 1;
        for(int i = 1 ; i < S.length() ; i++){
            if(S.charAt(i) == ch){
                count++;
            }
            else {
                if(count >= 3){
                    List<Integer> re = new ArrayList<Integer>();
                    re.add(startIndex);   re.add(i - 1);
                    result.add(re);
                }
                count = 1;
                ch = S.charAt(i);
                startIndex = i;
            }
        }
        
        if(count >= 3){
            List<Integer> re = new ArrayList<Integer>();
            re.add(startIndex);   re.add(S.length() - 1);
            result.add(re);
        }
        return result;
    }
}
