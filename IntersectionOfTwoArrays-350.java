class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       
        HashMap<Integer, Integer> hash = new HashMap<>();
       
        for(int i = 0 ; i < nums1.length ; i++)
        {
            if(hash.containsKey(nums1[i]))
                hash.put(nums1[i], hash.get(nums1[i]) + 1);
            else
                hash.put(nums1[i], 1);
        }
       
        ArrayList<Integer> output = new ArrayList<>();
        for(int i = 0 ; i < nums2.length ; i++){
            if(hash.containsKey(nums2[i]) && hash.get(nums2[i]) > 0){
                output.add(nums2[i]);
                hash.put(nums2[i], hash.get(nums2[i]) - 1);
            }
        }
       
        int [] result = new int[output.size()];
        for(int i = 0 ; i < output.size() ; i++)
            result[i] = output.get(i);
       
        return result;
       
    }
}
