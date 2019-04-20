/*

 You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:

Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]

Note:

    The number of given pairs will be in the range [1, 1000].

*/


class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length < 1) return 0;
        

	// We sort the array based on the end index
	// and if the end index is same, the secondary sorting order is the start index
        Arrays.sort(pairs, (a,b) -> {
           return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        });
        

	// We then pick the first pair and then skip through all the pairs which are 
	// having the start index less than the current bound value (which is nothing but the
	// current endvalue of the bound. 
	// Our max length keeps the track of the iterations that we have made

        int maxLen = 0;
        int counter = 0, bound = 0;
        while(counter < pairs.length){
            bound = pairs[counter][1];
            while(counter < pairs.length && bound >= pairs[counter][0])
                counter++;
            maxLen++;
        }
        
        return maxLen;    
    }
}
