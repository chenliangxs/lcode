/**

Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4
Explanation: The two words can be "ab", "cd".
Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0
Explanation: No such pair of words.

**/

public int maxProduct(String[] words) {
    Map<Integer, Integer> map = new HashMap<>();
    for(String s : words) {
        int mask = getMask(s);
        if(map.containsKey(mask)) {
            map.put(mask, Math.max(s.length(), map.get(mask)));
        } else {
            map.put(mask, s.length());
        }
    }
    int res = 0;
    for(int i : map.keySet()) {
        for(int j : map.keySet()) {
            if((i & j) == 0) {
                res = Math.max(res, map.get(i) * map.get(j));
            }
        }
    }
    return res;
}
public int getMask(String s) {
    int res = 0;
    for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        res |= (1 << (ch - 'a'));
    }
    return res;
}
