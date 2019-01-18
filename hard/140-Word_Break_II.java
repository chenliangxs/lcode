/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
**/

public List<String> wordBreak(String s, List<String> wordDict) {
	//List<String> res = new ArrayList<>();
	Map<String, List<String>> map = new HashMap<>();
	Set<String> dict = new HashSet<>(wordDict);
	return dfs(s, dict, map);
}
public List<String> dfs(String s, Set<String> dict, Map<String, List<String>> map) {
	List<String> res = new ArrayList<>();
	if(s.length() == 0) {
		return res;
	}
	for(int i = 1; i <= s.length(); i++) {
		String first = s.substring(0, i);
		String second = (i == s.length() ? "" : s.substring(i));
		if(dict.contains(first)) {
			if(second.length() == 0) {
				res.add(first);
			} else {
				List<String> tmp = map.containsKey(second) ? map.get(second) : dfs(second, dict, map);
				for(String next : tmp) {
					res.add(first + " " + next);
				}
			}
		}
	}
	map.put(s, res);
	return res;
}














