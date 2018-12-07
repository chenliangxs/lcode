//
// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// Example:
//
// Input: [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2.
//     Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Note:
//
// You can assume that you can always reach the last index.
// ==========================================

public int jump(int[] nums) {
    if(nums.length == 1) return 0;
    int maxEnd = 0;
    int curMax = 0;
    int step = 1;
    for(int i = 0; i < nums.length; i++){
        maxEnd = Math.max(maxEnd, i + nums[i]);
        if(maxEnd >= nums.length - 1) return step;
        if(i == curMax){
            curMax = maxEnd;
            step++;
        }
    }
    return step;
}
