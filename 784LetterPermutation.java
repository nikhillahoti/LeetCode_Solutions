class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> lst = new ArrayList<String>();
        if(S == null || S.isEmpty()) {
            lst.add("");
            return lst;   
        }
        permutateLetters(new StringBuilder(S), 0);
        
        hash.add(S);
        for(String s: hash){
            lst.add(s);
        }
        return lst;
        
    }
    
    HashSet<String> hash = new HashSet<>();
    
    
    public void permutateLetters(StringBuilder sb, int index){
        while(index < sb.length()){
            if((sb.charAt(index) > 64 && sb.charAt(index) < 91) || (sb.charAt(index) > 96 && sb.charAt(index) < 123)) break;
            index++;
        }
        if(index == sb.length()) return;
        hash.add(sb.toString());
        permutateLetters(sb, index + 1);
        
        char ch = sb.charAt(index);
        if(sb.charAt(index) > 91)
            ch -= 32;
        else
            ch += 32;
        
        sb.setCharAt(index, ch);
    
        hash.add(sb.toString());
        permutateLetters(sb, index + 1);
    }
}
