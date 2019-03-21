class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        if(tokens == null) return 0;
        
        Arrays.sort(tokens);
        
        int left = 0, right = tokens.length - 1;
        int points = 0;
        while(left <= right){
            if(P >= tokens[left]){
                points++;
                P -= tokens[left++];
            }    
            else {
                if(right - left <= 1) break;
                if(points <= 0) break;
                P += tokens[right--];
                points--;
            }
        }
        
        return points;
    }
}
