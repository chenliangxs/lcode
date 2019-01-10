/**
Write a function to generate the generalized abbreviations of a word. 

Note: The order of the output does not matter.

Example:

Input: "word"
Output:
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
**/

public List<String> generateAbbreviations(String word) {
	List<String> res = new ArrayList<>();
	StringBuilder path = new StringBuilder();
	dfs(0, 0, word, path, res);
	return res;
}
public void dfs(int index, int preCount, String word, StringBuilder path, List<String> res) {
	int curLen = path.length();
	if(index >= word.length()) {
		if(preCount > 0) {
			path.append(preCount);
			res.add(path.toString());
			path.setLength(curLen);
			return;
		} else {
			res.add(path.toString());
			return;
		}
	}
	char ch = word.charAt(index);
	dfs(index + 1, preCount + 1, word, path, res);
	if(preCount > 0) {
		path.append(preCount);
	}
	path.append(ch);
	dfs(index + 1, 0, word, path, res);
	path.setLength(curLen);
	return;
}






















