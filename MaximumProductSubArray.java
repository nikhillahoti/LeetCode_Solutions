
public class MaximumProductSubArray {

    public static void main(String[] args) {
       
        int nums[] = {2,3,-2,-4, -8};
        MaximumProductSubArray MPSA = new MaximumProductSubArray();
        System.out.println(MPSA.maxProduct(nums) + "");
       
    }
   
   
    public int maxProduct(int[] nums) {
       
        if(nums.length < 0) return 0;
       
        if (nums.length == 1) return nums[0];
       
        /*
         We maintain the maximum and the minimum product obtained so far and at the current element
         decide if the current element should be included in the max or min product obtained so far.
         
         When we are at a negative number, the max product will be the product of the current element
         and the min product so far, so we flip the values.
         We however encounter a really low number and so that should be the new low number, so we assign
         that to the minValue
         */
       
        int maxValue = 0, minValue = 0;
        int max = nums[0];
        minValue = maxValue = nums[0];
       
        for(int i = 1 ; i < nums.length ; i++) {
           
            if(nums[i] < 0) {
                int newMax = minValue * nums[i];
                minValue = Integer.min(nums[i], maxValue * nums[i]);
                maxValue = newMax;
            }
            else {
                maxValue = Integer.max(maxValue * nums[i], nums[i]);
                minValue = Integer.min(minValue * nums[i], nums[i]);   
            }
               
            if(maxValue > max) max = maxValue;
           
        }
       
        return max;
    }
}



	
	
	

