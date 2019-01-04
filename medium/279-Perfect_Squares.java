/**
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3 
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
**/
public int numSquares(int n) {
	int[] res = new int[n + 1];
	for(int i = 1; i <= n; i++) {
		res[i] = i;
		for(int j = 1; j*j <= i; j++) {
			res[i] = Math.min(res[i - j*j] + 1, res[i]);
		}
	}
	return res[n];
}





















