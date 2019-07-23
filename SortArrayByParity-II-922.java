/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

 

Note:

    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000
*/

/*

*********************************** LOGIC ******************************************

So the idea is that we find the element in the odd places which is even, 
then we find the element in the even places which is odd
We then swap these two elements in the array to satisfy the required condition.

*/

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length < 1) return A;
        
        int odd = 1, even = 0;
        
        while(odd < A.length && even < A.length){
            while(odd < A.length){
                if(A[odd] % 2 == 0) break;
                odd += 2;
            }
            
            while(even < A.length){
                if(A[even] % 2 == 1) break;
                even += 2;
            }
            
            if(odd >= A.length && even >= A.length) break;
            
            int temp = A[odd];
            A[odd] = A[even];
            A[even] = temp;
            
            odd += 2; even += 2;                    
        }
        
        return A;
    }
}
