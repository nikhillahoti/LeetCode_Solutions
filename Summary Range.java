class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int i = 0;
        while(i < nums.length){
            int temp = nums[i];
            int runner = nums[i];
            while(i+1 < nums.length && runner + 1 == nums[i+1]){
                i++;
                runner++;
            }
            if(runner == temp){
                result.add(temp + "");
            }
            else{
                result.add(temp + "->" + runner);
            }
            i++;
        }
        return result;
    }
}
