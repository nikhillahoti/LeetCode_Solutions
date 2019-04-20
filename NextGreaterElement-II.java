class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int temp[] = {};
        if(nums == null || nums.length < 1) return temp;
        
	// Maintaining a Stack which contains all the elements which are greater 
	// For e.g. for arr = [5,6,8,0,2,9,0]
	// We start traversing from the element second to the last and Our stack would be 
	// Top -> [5,6,8,9] 
        Stack<Integer> stk = new Stack<>();
        
        // Add the elements into the stack. The above stack is created in this for loop 
        for(int i = nums.length - 2 ; i > -1 ; --i)
        {
            while(!stk.isEmpty() && stk.peek() <= nums[i])
                stk.pop();
            
            stk.push(nums[i]);
        }
        

	// We start traversing from the end of the array and at every step keep poping elements from the stack which are lower than 
	// the current index. If the stack is empty, no element is greater than this element and so we add -1 in the result at the
	// current index. If we do have a element greater than the current element, we have found a element just greater than this
	// current number and we add it to the result set.
        int [] result = new int[nums.length];
        for(int i = nums.length - 1 ; i > -1 ; i--){
            while(!stk.isEmpty() && stk.peek() <= nums[i])
                stk.pop();
            
            if(stk.isEmpty())
                result[i] = -1;
            else 
                result[i] = stk.peek();
            stk.push(nums[i]);
        }
        
        return result;
    }
}
