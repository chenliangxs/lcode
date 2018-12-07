Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

========================================

public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length < 1) return res;
        int ll = 0;
        int lr = nums.length - 1;
        while(ll <= lr){
            int mid = (ll + lr) >> 1;
            if(nums[mid] >= target){
                lr = mid - 1;
            }else{
                ll = mid + 1;
            }
        }
        if(ll >= nums.length || nums[ll] != target) return res;
        res[0] = ll;
        int rl = 0;
        int rr = nums.length - 1;
        while(rl <= rr){
            int mid = (rl + rr) >> 1;
            if(nums[mid] <= target){
                rl = mid + 1;
            }else{
                rr = mid - 1;
            }
        }
        res[1] = rr;
        return res;
    }