/**

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

**/

public int minSubArrayLen(int s, int[] nums) {
    int[] sum = new int[nums.length + 1];
    TreeMap<Integer, Integer> map = new TreeMap<>();
    map.put(0, 0);
    for(int i = 1; i <= nums.length; i++) {
        sum[i] = sum[i - 1] + nums[i - 1];
        map.put(sum[i], i);
    }
    int globalMin = Integer.MAX_VALUE;
    for(int i = 1; i <= nums.length; i++) {
        int curSum = sum[i];
        int target = curSum - s;
        if(map.floorEntry(target) != null) {
            int pos = map.floorEntry(target).getValue();
            globalMin = Math.min(globalMin, i - pos);
        }
    }
    return globalMin == Integer.MAX_VALUE ? 0 : globalMin;
}

//sol2
public int minSubArrayLen(int s, int[] nums) {
    int left = 0;
    int right = 0;
    int sum = 0;
    int global = Integer.MAX_VALUE;
    while(right < nums.length) {
        if(sum < s) {
            sum += nums[right];
            right++;
        }
        while(sum >= s) {
            global = Math.min(global, right - left);
            sum -= nums[left++];
        }
    }

    return global == Integer.MAX_VALUE ? 0 : global;
}
