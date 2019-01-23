/**
In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

Example

Input:
maxChoosableInteger = 10
desiredTotal = 11

Output:
false

Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.
**/

public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if(maxChoosableInteger >= desiredTotal) {
        return true;
    }
    if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
        return false;
    }
    Map<Integer, Boolean> map = new HashMap<>();
    return dfs(0, maxChoosableInteger, desiredTotal, map);
}
public boolean dfs(int used, int n, int desiredTotal, Map<Integer, Boolean> map) {
    if(map.containsKey(used)) {
        return map.get(used);
    }
    for(int i = n - 1; i >= 0; i--) {
        int mask = (1 << i);
        if((mask & used) == 0){
            if(i + 1 >= desiredTotal) {
                return true;
            } else {
                boolean flag = dfs(used | mask, n, desiredTotal - i - 1, map);
                if(!flag) {
                    map.put(used, true);
                    return true;
                }
            }
        }
    }
    map.put(used, false);
    return false;
}
