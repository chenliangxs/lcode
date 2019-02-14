/**
Given a non-empty string, encode the string such that its encoded length is the shortest.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.

Note:

k will be a positive integer and encoded string will not be empty or have extra space.
You may assume that the input string contains only lowercase English letters. The string's length is at most 160.
If an encoding process does not make the string shorter, then do not encode it. If there are several solutions, return any of them is fine.


Example 1:

Input: "aaa"
Output: "aaa"
Explanation: There is no way to encode it such that it is shorter than the input string, so we do not encode it.


Example 2:

Input: "aaaaa"
Output: "5[a]"
Explanation: "5[a]" is shorter than "aaaaa" by 1 character.


Example 3:

Input: "aaaaaaaaaa"
Output: "10[a]"
Explanation: "a9[a]" or "9[a]a" are also valid solutions, both of them have the same length = 5, which is the same as "10[a]".


Example 4:

Input: "aabcaabcd"
Output: "2[aabc]d"
Explanation: "aabc" occurs twice, so one answer can be "2[aabc]d".


Example 5:

Input: "abbbabbbcabbbabbbc"
Output: "2[2[abbb]c]"
Explanation: "abbbabbbc" occurs twice, but "abbbabbbc" can also be encoded to "2[abbb]c", so one answer can be "2[2[abbb]c]".
**/
public String encode(String s) {
    int n = s.length();
    String[][] dp = new String[n][n];
    //dp[i][j] = min dp[i][k] + dp[k+1][j]
    for(int i = n - 1; i >= 0; i--) {
        for(int j = i; j < n; j++) {
            String tmp = s.substring(i, j + 1);
            if(j - i < 4) {
                dp[i][j] = tmp;
            } else {
                dp[i][j] = tmp;
                for(int k = i; k < j; k++) {
                    String left = dp[i][k];
                    String right = dp[k + 1][j];
                    if(left.length() + right.length() < dp[i][j].length()) {
                        dp[i][j] = left + right;
                    }
                }
                //combine repeat
                for(int h = 0; h < tmp.length(); h++) {
                    String seg = tmp.substring(0, h + 1);
                    if(tmp.length() % seg.length() == 0 && tmp.replaceAll(seg, "").length() == 0) {
                        int count = tmp.length() / seg.length();
                        String after = count + "[" + dp[i][i + h] + "]";
                        if(after.length() < dp[i][j].length()) {
                            dp[i][j] = after;
                        }
                    }
                }
            }
        }
    }
    return dp[0][n - 1];
}
