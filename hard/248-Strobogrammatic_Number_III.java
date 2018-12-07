A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

Example:

Input: low = "50", high = "100"
Output: 3 
Explanation: 69, 88, and 96 are three strobogrammatic numbers.
Note:
Because the range might be a large number, the low and high numbers are represented as string.

===============================================


public int strobogrammaticInRange(String low, String high) {
        int[] res = {0};
        dfs("", Long.parseLong(low), Long.parseLong(high), res);
        dfs("0", Long.parseLong(low), Long.parseLong(high), res);
        dfs("1", Long.parseLong(low), Long.parseLong(high), res);
        dfs("8", Long.parseLong(low), Long.parseLong(high), res);
        return res[0];
    }
    public void dfs(String cur, long low, long high, int[] res){
        if(cur.length() > (high+"").length()) return;
        if(cur.length() == 1 || (cur.length() > 1 && cur.charAt(0) != '0')) {
            if(Long.parseLong(cur) >= low && Long.parseLong(cur) <= high) {
                res[0]++;
            }
        }
        dfs("0"+cur+"0", low, high, res);
        dfs("1"+cur+"1", low, high, res);
        dfs("8"+cur+"8", low, high, res);
        dfs("6"+cur+"9", low, high, res);
        dfs("9"+cur+"6", low, high, res);
    }