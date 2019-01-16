/**
Given a sorted array of integers nums and integer values a, b and c. Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.

The returned array must be in sorted order.

Expected time complexity: O(n)

Example 1:

Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
Output: [3,9,15,33]
Example 2:

Input: nums = [-4,-2,2,4], a = -1, b = 3, c = 5
Output: [-23,-5,1,7]
**/

public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
    int[] res = new int[nums.length];
    if(nums.length == 0) {
        return res;
    }
    int left = 0;
    int right = nums.length - 1;
    if(a >= 0) {
        int index = nums.length - 1;
        for(; index >= 0; index--) {
            int leftVal = nums[left] * nums[left] * a + nums[left] * b + c;
            int rightVal = nums[right] * nums[right] * a + nums[right] * b + c;
            res[index] = Math.max(leftVal, rightVal);
            if(res[index] == leftVal) {
                left++;
            } else {
                right--;
            }
        }
    } else {
        int index = 0;
        for(; index < nums.length; index++) {
            int leftVal = nums[left] * nums[left] * a + nums[left] * b + c;
            int rightVal = nums[right] * nums[right] * a + nums[right] * b + c;
            res[index] = Math.min(leftVal, rightVal);
            if(res[index] == leftVal) {
                left++;
            } else {
                right--;
            }
        }
    }
    return res;
}
