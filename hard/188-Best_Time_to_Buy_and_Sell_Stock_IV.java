/**
local[i][j] = max(local[i-1][j] , global[i-1][j-1]) +a[i] - a[i-1];
global[i][j] = max(local[i][j], global[i-1][j]);


Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.


=================================================
**/
s Solution {
    public int maxProfit(int k, int[] prices) {
    if( k==0 || prices.length==0) return 0;
    int n = prices.length;
    if(k >= n){
        return maximum(prices);
    }
    int[][] local = new int[n][k+1];
    int[][] global = new int[n][k+1];
    int globalMax = 0;
    for(int i=1; i<n; i++){
        for(int j=1; j<=k; j++){
            local[i][j] = Math.max(local[i-1][j], global[i-1][j-1]) + prices[i] - prices[i-1];
            global[i][j] = Math.max(local[i][j], global[i-1][j]);
            //globalMax = Math.max(globalMax, global[i][j]);
        }
    }
    return global[n-1][k];
}
public int maximum(int[] nums){
    int total = 0;
    for(int i=1; i<nums.length; i++){
        if(nums[i] > nums[i-1]){
            total += nums[i] - nums[i-1];
        }
    }
    return total;
}
