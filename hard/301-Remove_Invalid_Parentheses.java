/**
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
**/

public List<String> removeInvalidParentheses(String s) {
    List<String> res = new ArrayList<>();
    dfs(s, 0, 0, new char[]{'(', ')'}, res);
    return res;
}
public void dfs(String s, int cur, int pre, char[] check, List<String> res) {
    int count = 0;
    for(int i = cur; i < s.length(); i++) {
        if(s.charAt(i) == check[0]) {
            count++;
        } else if(s.charAt(i) == check[1]) {
            count--;
        }
        if(count >= 0) {
            continue;
        }
        else {
            for(int j = pre; j <= i; j++) {
                if((j == pre || s.charAt(j - 1) != s.charAt(j)) && s.charAt(j) == check[1]) {
                    dfs(s.substring(0, j) + s.substring(j + 1), i, j, check, res);
                }
            }
            return;
        }
    }
    StringBuilder rs = new StringBuilder(s);
    rs.reverse();
    if(check[0] == '(') {
        dfs(rs.toString(), 0, 0, new char[]{')', '('}, res);
    } else {
        res.add(rs.toString());
    }
}
