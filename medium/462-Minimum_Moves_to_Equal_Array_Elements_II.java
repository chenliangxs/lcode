/**
Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

You may assume the array's length is at most 10,000.

Example:

Input:
[1,2,3]

Output:
2

Explanation:
Only two moves are needed (remember each move increments or decrements one element):

[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
**/
public int minMoves2(int[] nums) {
    Arrays.sort(nums);
    int mid = nums.length / 2;
    int target = (nums.length % 2 == 0 ? (nums[mid - 1] + nums[mid]) / 2 : nums[mid]);
    int total = 0;
    for(int n : nums) {
        total += Math.abs(n - target);
    }
    return total;
}
