/**
Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

Input:
s = "ABAB", k = 2

Output:
4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input:
s = "AABABBA", k = 1

Output:
4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
**/

public int characterReplacement(String s, int k) {
	char[] chs = s.toCharArray();
	int max = 0;
	//char maxChar = ' ';
	int left = 0;
	Map<Character, Integer> count = new HashMap<>();
	int res = 0;
	for(int i = 0; i < chs.length; i++) {
		count.put(chs[i], count.getOrDefault(chs[i], 0) + 1);
		if(count.get(chs[i]) > max) {
			//maxChar = chs[i];
			max = count.get(chs[i]);
		}
		int replaced = i - left + 1 - max;
		if(replaced <= k) {
			res = Math.max(res, i - left + 1);
		} else {
			while(replaced > k) {
				count.put(chs[left], count.get(chs[left]) - 1);
				left++;
				replaced = i - left + 1 - max;
			}
		}
	}
	return res;
}