/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

Note:

    You may assume that the array does not change.
    There are many calls to sumRange function.
*/


class NumArray {

    // In the sum array, we keep the sum from 0 to each index.  
    // For every query, we subtract the value at the i-1 index in the sum array from
    // j index in the sum array.
    int sum[];
    public NumArray(int[] nums) {
        this.sum = new int[nums.length];
        
        long summ = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            summ += nums[i];
            sum[i] = (int) summ;
        }
    }
    
    public int sumRange(int i, int j) {
        if(i - 1 >= 0)
            return sum[j] - sum[i - 1];
        return sum[j];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
