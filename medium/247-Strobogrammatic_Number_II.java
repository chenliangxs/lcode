/**
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
**/

public List<String> findStrobogrammatic(int n) {
    List<String> res = new ArrayList<>();
    //StringBuilder sb = new StringBuilder();
    dfs("", n, res);
    dfs("0", n, res);
    dfs("1", n, res);
    dfs("8", n, res);
    return res;
}
public void dfs(String cur, int n, List<String> res) {
    if(cur.length() > n) {
        return;
    }
    if(cur.length() == n && (cur.length() == 1 || cur.charAt(0) != '0')) {
        res.add(cur);
        return;
    }
    dfs("0" + cur + "0", n, res);
    dfs("1" + cur + "1", n, res);
    dfs("8" + cur + "8", n, res);
    dfs("6" + cur + "9", n, res);
    dfs("9" + cur + "6", n, res);
}
