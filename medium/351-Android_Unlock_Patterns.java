/**
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.



Rules for a valid pattern:

Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.





Explanation:

| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.



Example:

Input: m = 1, n = 1
Output: 9
**/

public int numberOfPatterns(int m, int n) {
    int[] total = new int[]{0};
    Set<Integer> visited = new HashSet<>();
    for(int i = 1; i <= 9; i++) {
        visited.add(i);
        dfs(i, visited, m, n, total);
        visited.remove(i);
    }
    return total[0];
}
public void dfs(int curPos, Set<Integer> visited, int m, int n, int[] total) {
    if(visited.size() >= m && visited.size() <= n) {
        total[0]++;
    }
    int curRow = (curPos - 1) / 3;
    int curCol = (curPos - 1) % 3;
    for(int i = 1; i <= 9; i++) {
        if(i == curPos) {
            continue;
        }
        int nextRow = (i - 1) / 3;
        int nextCol = (i - 1) % 3;
        if(!visited.contains(i)) {
            if(nextRow == curRow && Math.abs(nextCol - curCol) == 2) {
                //curRow, 1, mid = 3 * curRow + 2;
                if(visited.contains(3*curRow + 2)) {
                    visited.add(i);
                    dfs(i, visited, m, n, total);
                    visited.remove(i);
                }
            } else if(nextCol == curCol && Math.abs(nextRow - curRow) == 2) {
                //mid: 1, curCol, mid = 4 + curCol
                if(visited.contains(4 + curCol)) {
                    visited.add(i);
                    dfs(i, visited, m, n, total);
                    visited.remove(i);
                }
            } else if(Math.abs(nextRow - curRow) == 2 && Math.abs(nextCol - curCol) == 2) {
                if(visited.contains(5)) {
                    visited.add(i);
                    dfs(i, visited, m, n, total);
                    visited.remove(i);
                }
            } else {
                visited.add(i);
                dfs(i, visited, m, n, total);
                visited.remove(i);
            }
        }
    }
}
