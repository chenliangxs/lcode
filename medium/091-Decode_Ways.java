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
	int[] res = new int[]{0};
	char[] chs = s.toCharArray();
	dfs(0, chs, res);
	return res[0];
}
public void dfs(int index, char[] chs, int[] res){
	if(index >= chs.length) {
		res[0]++;
		return;
	}
	if(chs[index] != '0') {
		dfs(index + 1, chs, res);
		if(chs[index] < '3' && index < chs.length - 1 && chs[index + 1] < '7') {
			dfs(index + 1, chs, res);
		}
	}
}



















