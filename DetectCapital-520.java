/*

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital if it has more than one letter, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:

Input: "USA"
Output: True

Example 2:

Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters. 

*/

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word == null || word.length() < 1) return false;
        
	// So we maintain a HashMap where we keep track of the occurences of each character
        HashMap<Character, Integer> caps = new HashMap<>();
        HashMap<Character, Integer> smalls = new HashMap<>();
        
        for(char ch: word.toCharArray())
        {
            if(ch < 97)
                caps.put(ch, caps.getOrDefault(ch, 0) + 1);
            else
                smalls.put(ch, smalls.getOrDefault(ch, 0) + 1);
        }
        
	// If we do not get any lowercase characters or we do not get any uppercase characters, we know it is a valid Capital Word
        if(caps.size() == 0 || smalls.size() == 0) return true;

	// Else we check if there is only one capital character and it has occured once and in the first postion, if YES, we know it is a valid Capital word
        if(caps.size() == 1 && word.charAt(0) < 97){
            for(Character ch: caps.keySet())
                if(caps.get(ch) == 1) return true;            
            return false;
        } 

	// Else we just return false
        return false;
    }
}


// Time Complexity - O(n)
// Space Complexity - O(1) because in worst case our hashmap will have 26 (lowercase) + 26 (uppercase) entries. 



