Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

The solution set must not contain duplicate quadruplets.

Example:

Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]

============================================

public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> next = threeSum(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i]);
            if(next.size() > 0){
                for(List<Integer> tmp : next){
                    tmp.add(0, nums[i]);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    public List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(nums);
			for(int i = 0; i < nums.length; i++){
				if(i > 0 && nums[i] == nums[i - 1]) continue;
				int left = i + 1;
				int right = nums.length - 1;
				while(left < right){
					if(nums[i] + nums[left] + nums[right] == target){
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[left]);
						temp.add(nums[right]);
						res.add(temp);
						left++;
						right--;
						while(left < right && nums[left] == nums[left - 1]) left++;
					}else if(nums[left] + nums[right] + nums[i] > target){
						right--;
					}else{
						left++;
					}
				}
			}
			return res;
    }