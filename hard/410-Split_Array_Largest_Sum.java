/**
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
**/

public int find(int[] nums, int m){
	int n = nums.length;
	long[] sum = new long[n];
	sum[0] = nums[0];
	for(int i = 1; i < n; i++){
		sum[i] = sum[i - 1] + nums[i];
	}
	long[][] dp = new long[n][m];
	for(int i = 0; i < n; i++){
		dp[i][0] = sum[i];
	}
	for(int i = 0; i < n; i++){
		for(int j = 1; j < Math.min(i+1,m); j++){
			dp[i][j] = Integer.MAX_VALUE;
			for(int k = 0; k < i; k++){
				dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j-1], sum[i] - sum[k]));
			}
		}
	}
	return (int)dp[n - 1][m - 1];
}
//
public int splitArray(int[] nums, int m) {
    int n = nums.length;
    long[] sum = new long[n + 1];
    for(int i = 1; i <= n; i++) {
        sum[i] = sum[i - 1] + nums[i - 1];
    }
    long[][] dp = new long[n][m];
    //dp[i][1] = sum[i + 1]
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            dp[i][j] = sum[i + 1];
            if(j == 0) {
                continue;
            }
            for(int k = 0; k < i; k++) {
                dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sum[i + 1] - sum[k + 1]));
            }
        }
    }
    return (int)dp[n - 1][m - 1];
}
