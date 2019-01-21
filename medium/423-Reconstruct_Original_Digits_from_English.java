/**
Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.

Note:
Input contains only lowercase English letters.
Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
Input length is less than 50,000.
Example 1:
Input: "owoztneoer"

Output: "012"
Example 2:
Input: "fviefuro"

Output: "45"
**/

public String originalDigits(String s) {
	int[] count = new int[26];
	for(int i = 0; i < s.length(); i++) {
		count[s.charAt(i) - 'a']++;
	}
	StringBuilder res = new StringBuilder();
	int[] ans = new int[10];
	if(count['z' - 'a'] > 0) {
		ans[0] = count[25];
		count['e' - 'a'] -= count[25];
		count['r' - 'a'] -= count[25];
		count['o' - 'a'] -= count[25];
		count['z' - 'a'] -= count[25];
	}
	if(count['w' - 'a'] > 0) {
		ans[2] = count['w' - 'a'];
		count['t' - 'a'] -= count['w' - 'a'];
		count['o' - 'a'] -= count['w' - 'a'];
		count['w' - 'a'] -= count['w' - 'a'];
	}
	if(count['u' - 'a'] > 0) {
		ans[4] = count['u' - 'a'];
		count['f' - 'a'] -= ans[4];
		count['o' - 'a'] -= ans[4];
		count['r' - 'a'] -= ans[4];
		count['u' - 'a'] -= ans[4];
	}
	if(count['g' - 'a'] > 0) {
		ans[8] = count['g' - 'a'];
		count['e' - 'a'] -= ans[8];
		count['i' - 'a'] -= ans[8];
		count['h' - 'a'] -= ans[8];
		count['t' - 'a'] -= ans[8];
		count['g' - 'a'] -= ans[8];
	}
	if(count['x' - 'a'] > 0) {
		ans[6] = count['x' - 'a'];
		count['s' - 'a'] -= ans[6];
		count['i' - 'a'] -= ans[6];
		count['x' - 'a'] -= ans[6];
	}
	if(count['f' - 'a'] > 0) {
		ans[5] = count['f' - 'a'];
		count['i' - 'a'] -= ans[5];
		count['v' - 'a'] -= ans[5];
		count['e' - 'a'] -= ans[5];
		count['f' - 'a'] -= ans[5];
	}
	if(count['o' - 'a'] > 0) {
		ans[1] = count['o' - 'a'];
		count['o' - 'a'] -= ans[1];
		count['n' - 'a'] -= ans[1];
		count['e' - 'a'] -= ans[1];
	}
	if(count['t' - 'a'] > 0) {
		ans[3] = count['t' - 'a'];
		count['t' - 'a'] -= ans[3];
		count['h' - 'a'] -= ans[3];
		count['r' - 'a'] -= ans[3];
		count['e' - 'a'] -= 2 * ans[3];
	}
	if(count['s' - 'a'] > 0) {
		ans[7] = count['s' - 'a'];
		count['s' - 'a'] -= ans[7];
	}
	ans[9] = count['i' - 'a'];
	for(int i = 0; i < 10; i++) {
		for(int j = 0; j < ans[i]; j++) {
			res.append(i);
		}
	}
	return res.toString();
}