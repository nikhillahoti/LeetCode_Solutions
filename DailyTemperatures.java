public class DailyTemperature {

    public static void main(String[] args) {
       
        int []nums = {73,74,75,71,69,72,76,73};
        DailyTemperature DT = new DailyTemperature();
        nums = DT.dailyTemperatures(nums);
        for(int i = 0 ; i < nums.length ; i++)
            System.out.println(nums[i]);   
    }
   
     public int[] dailyTemperatures(int[] T) {
           
        int [] daysRequired = new int[T.length];
       
        daysRequired[T.length - 1] = 0;
        for(int i = T.length - 2 ; i > -1 ; i--) {
           
            // The next days temperature is greater than present day and so only 1 day is required
            if(T[i] < T[i+1]) {
                daysRequired[i] = 1;
            }
            else {
                int j = i + 1;
                while(j < T.length) {
                   
                    if(T[i] < T[j]) {
                        daysRequired[i] = j - i;
                        break;
                    }
                   
                    if(daysRequired[j] == 0) {
                        daysRequired[i] = 0;
                        break;
                    }
                    j += daysRequired[j];
                }
            }
        }
       
        return daysRequired;
    }
   
}
