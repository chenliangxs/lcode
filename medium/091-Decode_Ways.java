/**
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.

Example 1:

Input: "12"
Output: 2
Explanation: It could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: "226"
Output: 3
Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

**/

public int numDecodings(String s) {
    if(s.length() == 0) {
        return 0;
    }
    int n = s.length();
    char[] chs = s.toCharArray();
    int[] count = new int[n + 1];
    count[0] = 1;
    for(int i = 1; i <= n; i++) {
        if(i == 1) {
            if(chs[i - 1] == '0') {
                return 0;
            } else {
                count[i] = 1;
            }
        } else {
            if(chs[i - 1] == '0' && (chs[i - 2] > '2' || chs[i - 2] == '0')) {
                return 0;
            }
            if(chs[i - 1] > '0') {
                count[i] += count[i - 1];
            }
            if(chs[i - 2] == '1' || (chs[i - 2] == '2' && chs[i - 1] < '7')) {
                count[i] += count[i - 2];
            }
        }
    }
    return count[n];
}
