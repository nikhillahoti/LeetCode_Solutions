class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        int result[] = {};
        
        if(nums1 == null || nums2 == null) return result;
        
        Stack<Integer> stk = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        int index = nums2.length - 1;
        while(index > -1){
            while(!stk.isEmpty() && stk.peek() < nums2[index])
                stk.pop();
            
            if(stk.isEmpty())
                map.put(nums2[index], -1);
            else
                map.put(nums2[index], stk.peek());
            
            stk.push(nums2[index]);
            index--;
        }
        
        result = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++)
            result[i] = map.get(nums1[i]);
        
        return result;
    }
}
