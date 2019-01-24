/**
Consider the string s to be the infinite wraparound string of "abcdefghijklmnopqrstuvwxyz", so s will look like this: "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".

Now we have another string p. Your job is to find out how many unique non-empty substrings of p are present in s. In particular, your input is the string p and you need to output the number of different non-empty substrings of p in the string s.

Note: p consists of only lowercase English letters and the size of p might be over 10000.

Example 1:
Input: "a"
Output: 1

Explanation: Only the substring "a" of string "a" is in the string s.
Example 2:
Input: "cac"
Output: 2
Explanation: There are two substrings "a", "c" of string "cac" in the string s.
Example 3:
Input: "zab"
Output: 6
Explanation: There are six substrings "z", "a", "b", "za", "ab", "zab" of string "zab" in the string s.
**/

public int findSubstringInWraproundString(String p) {
	int[] count = new int[26];
	char[] chs = p.toCharArray();
	int len = 1;
	for(int i = 0; i < chs.length; i++) {
		if(i > 0 && isContinue(chs, i - 1, i)) {
			len++;
		} else {
			len = 1;
		}
		count[chs[i] - 'a'] = Math.max(count[chs[i] - 'a'], len);
	}
	
	int total = 0;
	for(int i = 0; i < 26; i++) {
		total += count[i];
	}
	return total;
}
public boolean isContinue(char[] chs, int i, int j) {
	if(chs[j] - chs[i] == 1) {
		return true;
	}
	if(chs[j] == 'a') {
		return chs[i] == 'z';
	}
	return false;
}
