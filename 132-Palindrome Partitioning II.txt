Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

==========================================================

public int minCut(String s) {
        if(s.length() == 0) return 0;
        int n = s.length();
        int[] cut = new int[n];
        boolean[][] dp = new boolean[n][n];
        for(int i=n-1; i>=0; i--){
            cut[i] = n - 1 - i;
            for(int j=n-1; j>=i; j--){
                if(i==j) dp[i][j] = true;
                else if(i == j-1) dp[i][j] = (s.charAt(i) == s.charAt(j))?true:false;
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
                if(dp[i][j]){
                    cut[i] = (j == n-1)? 0:Math.min(cut[i], 1 + cut[j+1]);
                }
            }
        }
        return cut[0];
    }