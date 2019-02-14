/**
Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.
A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Example:
Input: ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]

Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]

Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Note:
The number of elements of the given array will not exceed 10,000
The length sum of elements in the given array will not exceed 600,000.
All the input string will only include lower case letters.
The returned elements order does not matter.
**/

public List<String> findAllConcatenatedWordsInADict(String[] words) {
    List<String> res = new ArrayList<>();
    Set<String> dict = new HashSet<>();
    for(String word : words) {
        dict.add(word);
    }
    for(String word : words) {
        if(dfs(word, dict, word) > 1) {
            res.add(word);
        }
    }
    return res;
}
public int dfs(String word, Set<String> dict, String origin) {
    if(word.length() == 0) {
        return 0;
    }
    for(int i = 0; i < word.length(); i++) {
        String left = word.substring(0, i + 1);
        if(!left.equals(origin) && dict.contains(left)) {
            int next = dfs(word.substring(i + 1), dict, origin);
            if(next != -1) {
                return 1 + next;
            }
        }
    }
    return -1;
}
