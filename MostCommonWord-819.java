class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || paragraph.length() < 1) return "";
        
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        
        HashSet<String> band = new HashSet<>();
        for(int i = 0 ; i < banned.length ; i++)
            band.add(banned[i]);
        
        HashMap<String, Integer> hash = new HashMap<>();
        for(int i = 0 ; i < words.length ; i++){
            if(band.contains(words[i])) continue;
            hash.put(words[i], hash.getOrDefault(words[i], 0) + 1);
        }
        
        int max = Integer.MIN_VALUE;
        String maxStr = words[0];
        
        for(String key : hash.keySet()){
            if(hash.get(key) > max){
                maxStr = key;
                max = hash.get(key);
            }
        }
        return maxStr;
    }
}
