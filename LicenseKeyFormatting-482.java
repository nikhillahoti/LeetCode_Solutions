class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        
        if(S == null || S.length() < 1 || K < 0)
            return sb.toString();
        
        int counter = 0;
        for(int i = S.length() - 1 ; i >= 0 ; --i){
            if(S.charAt(i) == '-') continue;
            if(S.charAt(i) >= 97)
            {
                int val = S.charAt(i) - 32;
                sb.append((char)val + "");   
            }
            else
                sb.append(S.charAt(i));
            ++counter;
            if(counter == K){
                sb.append("-");
                counter = 0;
            }
        }    
        
        String output = sb.reverse().toString();
        if(output.length() > 0 && output.charAt(0) == '-')
            return output.substring(1, output.length());
        return output;
    }
}
