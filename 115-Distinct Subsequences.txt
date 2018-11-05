Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^


s: a b c d
       i
p: A B 
        j
dp[i][j]: count at si, pj.

dp[i][j]
1. s[i] == p[j]: dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
2. s[i] != p[j]: dp[i][j] = dp[i-1][j]
=================================================

public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;
        for(int i=0; i<=m ;i++){
            for(int j = 0; j<=n; j++){
                if(i==0 || j==0){
                    if(i==0 && j==0) continue;
                    else if(i==0) continue;
                    else dp[i][j] = 1;
                }else{
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
        return dp[m][n];
    }