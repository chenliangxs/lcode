/**
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
**/
public int longestSubstring(String s, int k) {
    if(s.length() == 0) {
        return 0;
    }
    char[] chs = s.toCharArray();
    int[] count = new int[26];
    for(char ch : chs) {
        count[ch - 'a']++;
    }
    Set<Character> breakPoint = new HashSet<>();
    for(int i = 0; i < 26; i++) {
        if(count[i] > 0 && count[i] < k) {
            char target = (char)('a' + i);
            breakPoint.add(target);
            System.out.println(target);
        }
    }
    if(breakPoint.size() == 0) {
        return s.length();
    }
    int res = 0;
    int leftIndex = 0;
    for(int i = 0; i <= chs.length; i++) {
        if(i == chs.length || breakPoint.contains(chs[i])) {
            int candidate = longestSubstring(s.substring(leftIndex, i), k);
            res = Math.max(res, candidate);
            leftIndex = i + 1;
        }
    }
    return res;
}
