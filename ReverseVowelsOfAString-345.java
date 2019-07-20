class Solution {
    public String reverseVowels(String s) {
        
        if(s == null || s.length() < 1) return s;
        
        StringBuilder sb = new StringBuilder(s);
        int left = 0;
        int right = s.length() - 1;
        
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i');
        vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I');
        vowels.add('O'); vowels.add('U');
        
        
        while(left < right){
            while(left < right){
                if(vowels.contains(s.charAt(left))) break;
                left++;
            }
            
            while(right > left){
                if(vowels.contains(s.charAt(right))) break;
                right--;
            }
            
            if(left == right) break;
            
            char c = s.charAt(left);
            sb.setCharAt(left, s.charAt(right));
            sb.setCharAt(right, c);
            
            left++;
            right--;
        }
        
        return sb.toString();
    }
}
