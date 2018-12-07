Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

=========================================

public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(nums);
			for(int i = 0; i < nums.length; i++){
				if(i > 0 && nums[i] == nums[i - 1]) continue;
				int left = i + 1;
				int right = nums.length - 1;
				while(left < right){
					if(nums[i] + nums[left] + nums[right] == 0){
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[left]);
						temp.add(nums[right]);
						res.add(temp);
						left++;
						right--;
						while(left < right && nums[left] == nums[left - 1]) left++;
					}else if(nums[left] + nums[right] > -1 * nums[i]){
						right--;
					}else{
						left++;
					}
				}
			}
			return res;
    }