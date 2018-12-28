/**

Given two strings s and t, determine if they are both one edit distance apart.

Note:

There are 3 possiblities to satisify one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t
Example 1:

Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.
Example 2:

Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.
Example 3:

Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.

**/

public boolean isOneEditDistance(String s, String t) {
    if(Math.abs(s.length() - t.length()) > 1) {
        return false;
    }
    int m = s.length();
    int n = t.length();
    int[][] count = new int[m + 1][n + 1];
    char[] chs = s.toCharArray();
    char[] cht = t.toCharArray();
    for(int i = 0; i <= m; i++) {
        for(int j = 0; j <= n; j++) {
            if(i == 0 && j == 0) {
                continue;
            } else if(i == 0) {
                count[i][j] = j;
            } else if(j == 0) {
                count[i][j] = i;
            } else {
                if(chs[i - 1] == cht[j - 1]) {
                    count[i][j] = count[i - 1][j - 1];
                } else {
                    count[i][j] = 1 + Math.min(count[i - 1][j - 1], Math.min(count[i - 1][j], count[i][j - 1]));
                }
            }
        }
    }
    return count[m][n] == 1;
}
