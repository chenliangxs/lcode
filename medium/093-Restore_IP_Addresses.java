/**

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:

Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]

**/

public List<String> restoreIpAddresses(String s) {
    List<String> res = new ArrayList<>();
    StringBuilder ip = new StringBuilder();
    if(s.length() < 4 || s.length() > 12) {
        return res;
    }
    char[] chs = s.toCharArray();
    dfs(0, 0, chs, ip, res);
    return res;
}
public void dfs(int index, int lvl, char[] chs, StringBuilder ip, List<String> res){
    if(lvl == 4 && index == chs.length) {
        ip.deleteCharAt(ip.length() - 1);
        res.add(ip.toString());
        return;
    }
    if(lvl > 4 || index >= chs.length) {
        return;
    }
    int curLen = ip.length();
    if(chs[index] == '0') {
        ip.append(chs[index]);
        ip.append('.');
        dfs(index + 1, lvl + 1, chs, ip, res);
        ip.setLength(curLen);
    } else {
        for(int i = 1; i <= 3; i++) {
            if(index + i <= chs.length){
                String seg = new String(chs, index, i);
                if(Integer.parseInt(seg) > 0 && Integer.parseInt(seg) < 256) {
                    ip.append(seg);
                    ip.append('.');
                    dfs(index + i, lvl + 1, chs, ip, res);
                    ip.setLength(curLen);
                }
            }
        }
    }
}
