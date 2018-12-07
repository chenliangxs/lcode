// s1: i
//
// s2: j
//
// s3: i+j - 1
//
// dp[i][j]: if(s[i] == s3[i+j-1]) dp[i-1][j]
// 	if s2[j] == s3[i+j-1] dp[i][j-1]
//
// else false;
//
// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
//
// Example 1:
//
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
// Output: true
// Example 2:
//
// Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
// Output: false
//=======================================

public boolean isInterleave(String s1, String s2, String s3) {
	int m = s1.length();
	int n = s2.length();
	if(m + n != s3.length()) return false;
	boolean[][] dp = new boolean[m+1][n+1];
	dp[0][0] = true;
	for(int i=0; i<=m; i++){
		for(int j=0; j<=n; j++){
			if(i==0 || j==0){
				if(i==0&&j==0) continue;
				else if(i==0){
					dp[i][j] = (s2.charAt(j-1) == s3.charAt(j-1) && dp[i][j-1]);
				}else{
					dp[i][j] = (s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][j]);
				}
			}else{
				dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) || (s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]);
			}
		}
	}
	return dp[m][n];
}
