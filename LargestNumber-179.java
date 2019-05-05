class Solution {
    public String largestNumber(int[] nums) {
        
        if(nums == null || nums.length < 1) return "";
        
        String num[] = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++)
            num[i] = nums[i] + "";
                
        Arrays.sort(num, (String a, String b) -> {
            return -(a + "" + b).compareTo(b + "" + a);
        });            
        
        StringBuilder sb = new StringBuilder();
        for(String n: num)
            sb.append(n + "");
        
        String output = sb.toString();
        int index = 0;
        for(index = 0 ; index < output.length() ; index++){
            if(output.charAt(index) != '0')
                break;
        }
        return index == output.length() ? "0" : output; 
    }
}
