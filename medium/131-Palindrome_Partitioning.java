/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
**/
public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    dfs(s, list, res);
    return res;
}
public void dfs(String s, List<String> list, List<List<String>> res) {
    if(s.length() == 0) {
        res.add(new ArrayList<String>(list));
        return;
    }
    for(int i = 1; i <= s.length(); i++) {
        String cur = s.substring(0, i);
        if(isPali(cur)) {
            list.add(cur);
            dfs(s.substring(i), list, res);
            list.remove(list.size() - 1);
        }
    }
}
public boolean isPali(String s) {
    if(s.length() < 2) {
        return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while(left <= right) {
        if(s.charAt(left) != s.charAt(right)) {
            return false;
        } else {
            left++;
            right--;
        }
    }
    return true;
}
