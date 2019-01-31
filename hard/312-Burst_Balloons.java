/**
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 �� n �� 500, 0 �� nums[i] �� 100
Example:

Input: [3,1,5,8]
Output: 167
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167


3, 1, 5, 8,   i

dp[i][j]: n[k] * n[i-1] * n[j+1] + dp[i][k-1] + dp[k+1][j];

range i : j, dp[i][j]: find a mid k, nums[x] * nums[k] * nums[y]: x [i,k - 1], y[k+1, j]
dp[i][j] = nums[x] * nums[k] * nums[y] + dp[x+1][k-1] + dp[k+1][y-1]
=========================================

**/

public int maxCoins(int[] nums) {
    if(nums.length == 0) return 0;
    int n = nums.length;
    int[][] dp = new int[n][n];
    for(int i = n - 1; i >= 0; i--){
        for(int j = i; j < n; j++){
            int max = Integer.MIN_VALUE;
            for(int k = i; k <= j; k++){
                max = Math.max(max,
                               nums[k] * (i == 0 ? 1 : nums[i - 1]) * (j == n - 1 ? 1 : nums[j + 1])
                               + (k > i ? dp[i][k - 1] : 0)
                               + (k < j ? dp[k+1][j] : 0)
                              );
            }
            dp[i][j] = max;
        }
    }
    return dp[0][n - 1];
}
