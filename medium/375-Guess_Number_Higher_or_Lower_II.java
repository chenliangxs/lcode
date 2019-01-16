/*8
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
**/
public int getMoneyAmount(int n) {
    int[][] dp = new int[n + 1][n + 1];
    for(int i = n; i > 0; i--) {
        Arrays.fill(dp[i], Integer.MAX_VALUE);
        for(int j = i; j <= n; j++) {
            if(i == j) {
                dp[i][j] = 0;
            } else if(i + 1 == j) {
                dp[i][j] = i;
            }else if(i + 2 == j) {
                dp[i][j] = i + 1;
            } else {
                for(int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max((k == i ? 0 : dp[i][k - 1]), (k == j ? 0 : dp[k + 1][j])));
                }
            }
        }
    }
    return dp[1][n];
}
