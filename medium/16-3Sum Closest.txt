
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

===========================================

public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDif = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == target - nums[i]) return target;
                else if(nums[left] + nums[right] > target - nums[i]){
                    if(Math.abs(target - nums[i] - nums[left] - nums[right]) < minDif){
                        minDif = Math.abs(target - nums[i] - nums[left] - nums[right]);
                        res = nums[left] + nums[right] + nums[i];
                    }
                    right--;
                }else{
                    if(Math.abs(target - nums[i] - nums[left] - nums[right]) < minDif){
                        minDif = Math.abs(target - nums[i] - nums[left] - nums[right]);
                        res = nums[left] + nums[right] + nums[i];
                    }
                    left++;
                }
            }
        }
        return res;
    }