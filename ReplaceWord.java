
// Problem 648
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        HashSet<String> hash = new HashSet<>();
        int counter = dict.size();
        for(int i = 0 ; i < counter ; i++)
            hash.add(dict.get(i));
        
        StringBuilder output = new StringBuilder();
        String []words = sentence.split(" ");
        for(int i = 0 ; i < words.length ; i++){
            String currentWord = words[i];
            int j = 0;
            boolean flag = true;
            while(j < currentWord.length()){
                // System.out.println(currentWord.substring(0,j + 1));
                if(hash.contains(currentWord.substring(0,j + 1))){
                    flag = false;
                    output.append(" " + currentWord.substring(0,j + 1));
                    break;
                }

                j++;
            }
            if(flag){
                output.append(" " + currentWord);
            }
        }
        return output.substring(1).toString();
    }
}
