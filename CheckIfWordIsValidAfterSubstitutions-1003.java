class Solution {
    public boolean isValid(String S) {
        
        if(S == null || S.length() < 1) return true;
        
        int [] cnt = new int[3];
        cnt[0] = 0; cnt[1] = 0; cnt[2] = 0;
        
        for(int i = 0 ; i < S.length() ; i++){
            if(S.charAt(i) == 'c' && (cnt[2] >= cnt[1] || cnt[2] >= cnt[0])) return false;
            if(S.charAt(i) == 'b' && (cnt[1] >= cnt[0] || cnt[1] < cnt[2])) return false;
            if(S.charAt(i) == 'a' && (cnt[0] < cnt[1] || cnt[0] < cnt[2])) return false;
            cnt[S.charAt(i) - 97]++;
        }
        
        if(cnt[0] == cnt[1] && cnt[1] == cnt[2]) 
            return true;
        return false;
    }
}
