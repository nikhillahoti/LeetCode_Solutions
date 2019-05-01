class Solution {
    public String toGoatLatin(String S) {
        
        if(S == null || S.length() < 1) return "";
        
        StringBuilder sb = new StringBuilder();
        
        vowels.add('a'); vowels.add('A'); 
        vowels.add('e'); vowels.add('E'); 
        vowels.add('i'); vowels.add('I'); 
        vowels.add('o'); vowels.add('O'); 
        vowels.add('u'); vowels.add('U'); 
        
        String[] words = S.split(" ");
        for(int i = 0 ; i < words.length ; i++){
            sb.append(GoatLatin(words[i], i + 1) + " ");
        }
                    
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    Set<Character> vowels = new HashSet<>();
    
    public String GoatLatin(String word, int index){
        if(vowels.contains(word.charAt(0))){
            // Vowel at the start 
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            sb.append("ma");
            while(index-- > 0)
                sb.append('a');
            return sb.toString();
        }
        else {
            StringBuilder sb = new StringBuilder();
            if(word.length() > 1)
                sb.append(word.substring(1, word.length()));
            sb.append(word.charAt(0) + "ma");
            while(index-- > 0)
                sb.append('a');
            return sb.toString();
        }
    }
}
