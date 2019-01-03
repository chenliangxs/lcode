/**
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
1. ����������
��ô Local(i, j) = Global(i-1, j-1)
�൱��ɶ��û��

2. ��������
��ô Local(i, j) = global(i-1, j-1) + diff
//����Global(i-1, j-1) �еĽ��ף����Ͻ����ɵ���һƱ

3. ����֮ǰ����
��ô Local(i, j) = local(i-1, j) + diff
���������ˣ�����������

����ʵ��һ�������ǲ���Ҫ���ǵģ���Ϊ����������������������������ȫ���ظ������������������Թ�����global[i-1][j-1]�У��������ǾͲ���Ҫmax(0, diff)�ˣ���ô�������������diff���������ǿ��԰�diff�鵽max�����棬���Ը��º��ĵ��ƹ�ʽΪ��

local[i][j] = max(global[i - 1][j - 1], local[i - 1][j]) + diff

global[i][j] = max(local[i][j], global[i - 1][j])

=======================================================
**/
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
