class Solution {
    public String customSortString(String s, String t) {
       
        if(s == null) return t;
        if(t == null) return "";
       
        int dp[] = new int[26];
        for(char c: t.toCharArray())
            dp[c - 97]++;
       
        StringBuilder permutatedStr = new StringBuilder();
        for(char c: s.toCharArray()){
            if(dp[c - 97] > 0){
                while(dp[c - 97]-- > 0)
                    permutatedStr.append(c);
            }
        }
       
        for(int i = 0 ; i < 26 ; i++)
            if(dp[i] > 0)
                while(dp[i]-- > 0)
                    permutatedStr.append((char)(i + 97));
       
        return permutatedStr.toString();
    }
}
