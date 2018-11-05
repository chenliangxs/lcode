Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.


=======================================================
1. 今天刚买的
那么 Local(i, j) = Global(i-1, j-1)
相当于啥都没干

2. 昨天买的
那么 Local(i, j) = global(i-1, j-1) + diff
//等于Global(i-1, j-1) 中的交易，加上今天干的那一票

3. 更早之前买的
那么 Local(i, j) = local(i-1, j) + diff
昨天别卖了，留到今天卖

但其实第一种情况是不需要考虑的，因为当天买当天卖不会增加利润，完全是重复操作，这种情况可以归纳在global[i-1][j-1]中，所以我们就不需要max(0, diff)了，那么由于两项都加上了diff，所以我们可以把diff抽到max的外面，所以更新后的递推公式为：

local[i][j] = max(global[i - 1][j - 1], local[i - 1][j]) + diff

global[i][j] = max(local[i][j], global[i - 1][j])

=======================================================
public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int n = prices.length;
        int[][] local = new int[n][3];
        int[][] global = new int[n][3];
        for(int i=1; i<n; i++){
            for(int j=1; j<=2; j++){
                local[i][j] = Math.max(local[i-1][j], global[i-1][j-1]) + (prices[i] - prices[i-1]);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[n-1][2];
    }