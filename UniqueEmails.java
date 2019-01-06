
// Problem No. 929
class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        for(int i = 0 ; i < emails.length ; i++)
            uniqueEmails.add(FilterEmailAddress(emails[i]));
        
        return uniqueEmails.size();
    }
    
    public String FilterEmailAddress(String emailId){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while((emailId.charAt(i) != '@') && i < emailId.length()){
            if(emailId.charAt(i) == '+') break;
            if(emailId.charAt(i) == '.'){
                i++;
                continue;  
            } 
            sb.append(emailId.charAt(i++));
        }
        
        if(emailId.charAt(i) == '+'){
            i++;
            while((emailId.charAt(i) != '@') && i < emailId.length()){
                i++;
            }
        }
        
        while(i < emailId.length()){
            sb.append(emailId.charAt(i++));
        }
        return sb.toString();
    }
}
