/**
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

Example 1:

Input: "aabb"
Output: ["abba", "baab"]
Example 2:

Input: "abc"
Output: []
**/

public List<String> generatePalindromes(String s) {
    List<String> res = new ArrayList<>();
    Map<Character, Integer> count = new HashMap<>();
    for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        count.put(ch, count.getOrDefault(ch, 0) + 1);
    }
    StringBuilder sb = new StringBuilder();
    int oddCount = 0;
    String odd = "";
    for(char ch : count.keySet()) {
        if(count.get(ch) % 2 != 0) {
            odd = ch+"";
            oddCount++;
            if(oddCount > 1) {
                return res;
            }
        }
        for(int i = 0; i < count.get(ch) / 2; i++) {
            sb.append(ch);
        }
    }
    char[] chs = sb.toString().toCharArray();
    sb.setLength(0);
    dfsPermutation(chs, 0, sb, odd, res);
    return res;
}

public void dfsPermutation(char[] chs, int index, StringBuilder sb, String odd, List<String> res) {
    if(index >= chs.length) {
        String left = sb.toString();
        String right = sb.reverse().toString();
        sb.reverse();
        String tmp = left + odd + right;
        res.add(tmp);
        return;
    }
    for(int i = index; i < chs.length; i++) {
        if(i > index && chs[i] == chs[i - 1]) {
            continue;
        }
        swap(chs, i, index);
        sb.append(chs[index]);
        dfsPermutation(chs, index + 1, sb, odd, res);
        sb.deleteCharAt(sb.length() - 1);
        swap(chs, i, index);
    }
}
public void swap(char[] chs, int i, int j) {
    char tmp = chs[i];
    chs[i] = chs[j];
    chs[j] = tmp;
}
