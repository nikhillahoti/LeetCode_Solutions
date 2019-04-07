class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        
        List<Boolean> output = new ArrayList<>();
        if(queries == null) return output;
        
        for(int k = 0 ; k < queries.length ;k++){
            
            String s = queries[k];
            int i = 0, j = 0;
            
            while( i < s.length() && j < pattern.length()){
                if(s.charAt(i) == pattern.charAt(j)){
                    i++;
                    j++;
                    continue;
                }
                while(i < s.length() && s.charAt(i) >= 97 && s.charAt(i) <= 122 && s.charAt(i) != pattern.charAt(j))
                    i++;
                if(i < s.length() && j < pattern.length() && s.charAt(i) != pattern.charAt(j))
                    break;
            }
            while( i < s.length() && s.charAt(i) >= 97)
                i++;
            if(j == pattern.length() && i == s.length())
                output.add(true);
            else
                output.add(false);
        }
        return output;
    }
}
