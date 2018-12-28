/**
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

**/

public int maxProduct(int[] nums) {
    long globalMax = Long.MIN_VALUE;
    int n = nums.length;
    long[] max = new long[n];
    long[] min = new long[n];
    for(int i = 0; i < nums.length; i++) {
        if(i == 0) {
            max[i] = (long)nums[0];
            min[i] = (long)nums[0];
        } else {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
        }
        globalMax = Math.max(globalMax, max[i]);
    }
    return (int)globalMax;
}
