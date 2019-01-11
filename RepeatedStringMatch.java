// Problem N0. 648
class Solution {
    public int repeatedStringMatch(String A, String B) {
        HashSet<Character> uniqueCharsStringA = new HashSet<>();
        for(int i = 0 ; i < A.length() ; i++){
            if(!uniqueCharsStringA.contains(A.charAt(i))){
                uniqueCharsStringA.add(A.charAt(i));
            }
        }
        
        HashSet<Character> uniqueCharsStringB = new HashSet<>();
        for(int i = 0 ; i < B.length() ; i++){
            if(!uniqueCharsStringB.contains(B.charAt(i))){
                uniqueCharsStringB.add(B.charAt(i));
            }
        }
        
        if(uniqueCharsStringB.size() > uniqueCharsStringA.size()) return -1;
        if(A.contains(B)) return 1;
        if((A + A).contains(B)) return 2;
        
        int counter = 0;
        StringBuilder sb = new StringBuilder(1);
        while(sb.length() < 2 * B.length()){
            sb.append(A);
            counter++;
            if(sb.toString().contains(B)){
                return counter;
            }
            
        }
        return -1;
    }
}
