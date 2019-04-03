class Solution {
    public int longestPalindrome(String s) {
        
        if(s == null || s.length() < 1) return 0;
        
        HashMap<Character, Integer> hash = new HashMap<>();
        for(char ch: s.toCharArray())
            hash.put(ch, hash.getOrDefault(ch, 0) + 1);
        
        int count = 0;
        boolean flag = false;
        for(Character ch: hash.keySet()){
            int occurence = hash.get(ch);
            if(occurence % 2 == 0)
                count += occurence;
            else {
                flag = true;
                count += (occurence - 1);
            }
        }
        return flag ? count + 1 : count;
    }
}
