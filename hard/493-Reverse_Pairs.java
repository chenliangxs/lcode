/**
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
Note:
The length of the given array will not exceed 50,000.
All the numbers in the input array are in the range of 32-bit integer.
**/

//sol1
class Solution {
    public int reversePairs(int[] nums) {
        int[] res = new int[]{0};
        mergeCount(nums, 0, nums.length, res);
        return res[0];
    }
    public void mergeCount(int[] nums, int left, int right, int[] res) {
        if(left + 1 >= right) {
            return;
        }
        int mid = (left + right) >> 1;
        mergeCount(nums, left, mid, res);
        mergeCount(nums, mid, right, res);
        for(int i = mid; i < right; i++) {
            int bottom = mid - 1;
            while(bottom >= left && nums[bottom] / 2.0 > nums[i]) {
                res[0]++;
                bottom--;
            }
        }
        Arrays.sort(nums, left, right);
    }
}
//sol2
