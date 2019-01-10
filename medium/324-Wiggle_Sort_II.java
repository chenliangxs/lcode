/**
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example 1:

Input: nums = [1, 5, 1, 1, 6, 4]
Output: One possible answer is [1, 4, 1, 5, 1, 6].
Example 2:

Input: nums = [1, 3, 2, 2, 3, 1]
Output: One possible answer is [2, 3, 1, 3, 1, 2].
Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
**/

public void wiggleSort(int[] nums) {
	Arrays.sort(nums);
	int[] res = new int[nums.length];
	int index = 0;
	int mid = (nums.length - 1) / 2;
	int i = mid;
	int j = nums.length - 1;
	while(j > mid) {
		res[index++] = nums[i--];
		res[index++] = nums[j--];
	}
	if(nums.length % 2 == 1) {
		res[index] = nums[i];
	}
	for(int x = 0; x < nums.length; x++) {
		nums[x] = res[x];
	}
}







