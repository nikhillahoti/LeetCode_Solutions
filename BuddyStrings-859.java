/*
Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

 

Example 1:

Input: A = "ab", B = "ba"
Output: true

Example 2:

Input: A = "ab", B = "ab"
Output: false

Example 3:

Input: A = "aa", B = "aa"
Output: true

Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:

Input: A = "", B = "aa"
Output: false

 

Note:

    0 <= A.length <= 20000
    0 <= B.length <= 20000
    A and B consist only of lowercase letters.



*/

class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A == null && B == null) return true;
        if(A == null || B == null) return false;
        
        if(A.length() != B.length()) return false;

	// For every position, me check if there is mismatch at that index        
        List<Integer> mismatches = new ArrayList<>();
        
        for(int i = 0 ; i < A.length() ; i++)
            if(A.charAt(i) != B.charAt(i))
                mismatches.add(i);

	
	// if the number of mismatch are greater than 2, we know swapping cannot work, so we return false
        if(mismatches.size() > 2) return false;
 
	// if mismatches are 0, we check if there are duplicate characters which can be swapped and string would still be equal after that else, we return false;       
        if(mismatches.size() == 0){
            Set<Character> freq = new HashSet<>();
            for(char ch: A.toCharArray()){
                if(freq.contains(ch)) return true;
                freq.add(ch);
            }
            return false;
        }
 
	// we check if the indexes can be swapped.       
        if(A.charAt(mismatches.get(0)) == B.charAt(mismatches.get(1)) && A.charAt(mismatches.get(1)) == B.charAt(mismatches.get(0)))
            return true;
        return false;
        
    }
}
