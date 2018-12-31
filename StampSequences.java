class Solution {
   public int[] movesToStamp(String stamp, String target) {
        int [] validData = matchStamp(stamp, target, new ArrayList<>());
       if(validData == null) {
           int arr[] = {};
            return arr;
       }
        for(int i = 0; i < validData.length / 2; i++)
        {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
        return validData;
	 }
	 
	 public int [] matchStamp(String stamp, String updatedString, ArrayList<Integer> indexes){
	     int lastIndex = updatedString.length();
	     int iter = updatedString.length() - 1;
	     	
         lastIndex = checkSubstring(stamp, updatedString, lastIndex - 1);

         if (lastIndex == -1) return null;

         StringBuilder SB = new StringBuilder(updatedString);
         int counter = stamp.length() + lastIndex;
         for(int i = lastIndex ; i < counter ; i++){
             SB.setCharAt(i, '?');
         }

         // Add Index to the indexes
         ArrayList<Integer> intermIndexes = new ArrayList<>(indexes);
         intermIndexes.add(lastIndex);

         counter = SB.toString().length();
         int i = 0;
         for(i = 0 ; i < counter ; i++) {
             if(SB.charAt(i) != '?') {
                 break;
             }
         }

         if(i == counter) {
             int myResult[] = new int[intermIndexes.size()];
             for(i = 0 ; i < myResult.length ; i++) {
                 myResult[i] = intermIndexes.get(i);
             }
             return myResult;
         }

         int [] result = matchStamp(stamp, SB.toString(), intermIndexes);
         if(result != null){
             return result; 
         }

        return null;
	 }
	 
	 public int checkSubstring(String stamp, String target, int startIndex){
		
	     int i = startIndex;
	     while(i > -1){
	         
	    	 if(target.charAt(i) == stamp.charAt(stamp.length() - 1) || target.charAt(i) == '?') {
	    		 int j = i;
	    		 int k = stamp.length() - 1;
	    		 boolean flag = false;
	    		 while( k > -1 && j > -1) {
	    			 if(target.charAt(j) == '?') {
	    				 k--; j--; continue;
	    			 }
	    			 if(target.charAt(j) == stamp.charAt(k)) {
	    				 k--; j--; 
	    				 flag = true;
	    				 continue;
	    				 
	    			 }
	    			 break;
	    		 }
	    		 if(k == -1 && flag) return j + 1;
	    	 }
	    	 i--;
	     }
	     return -1;
	 }
	
}
