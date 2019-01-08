/**
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
**/
//buy[i] = max(sell[i - 2] - p[i], buy[i - 1] + p[i - 1] - p[i]);
//sell[i] = max(buy[i - 1] + p[i], sell[i - 1] + p[i] - p[i - 1]);
public int maxProfit(int[] prices) {
    if(prices.length < 2) {
        return 0;
    }
    int[] buy = new int[prices.length];
    int[] sell = new int[prices.length];
    int globalMax = 0;
    buy[0] = -1 * prices[0];
    buy[1] = -1 * prices[1];
    sell[1] = prices[1] - prices[0];
    globalMax = Math.max(globalMax, sell[1]);
    for(int i = 2; i < prices.length; i++) {
        buy[i] = Math.max(sell[i - 2] - prices[i], buy[i - 1] + prices[i - 1] - prices[i]);
        sell[i] = Math.max(buy[i - 1] + prices[i], sell[i - 1] + prices[i] - prices[i - 1]);
        globalMax = Math.max(globalMax, sell[i]);
    }
    return globalMax;
}
