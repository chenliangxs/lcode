
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

========================================

public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        if(n == 0) return res;
        dfs(0, 0, n, path, res);
        return res;
    }
    public void dfs(int left, int right, int n, StringBuilder path, List<String> res){
        if(left == n && right == n){
            res.add(path.toString());
            return;
        }
        if(left < n){
            path.append('(');
            dfs(left + 1, right, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        if(right < left){
            path.append(')');
            dfs(left, right + 1, n, path, res);
            path.deleteCharAt(path.length() - 1);
        }
        return;
    }