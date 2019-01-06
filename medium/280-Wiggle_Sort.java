/**
Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

Example:

Input: nums = [3,5,2,1,6,4]
Output: One possible answer is [3,5,1,6,2,4]
**/

public void wiggleSort(int[] nums) {
    for(int i = 0; i < nums.length; i++) {
        if(i % 2 == 1) {
            if(nums[i] > nums[i - 1]) {
                continue;
            } else {
                swap(nums, i - 1, i);
            }
        } else {
            if(i > 0 && nums[i] > nums[i - 1]) {
                swap(nums, i - 1, i);
            } else {
                continue;
            }
        }
    }
}
public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
}
