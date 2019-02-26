/**
Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.

Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.

Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.

Examples:

Input: "WRRBBW", "RB"
Output: -1
Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW

Input: "WWRRBBWW", "WRBRW"
Output: 2
Explanation: WWRRBBWW -> WWRR[R]BBWW -> WWBBWW -> WWBB[B]WW -> WWWW -> empty

Input:"G", "GGGGG"
Output: 2
Explanation: G -> G[G] -> GG[G] -> empty

Input: "RBYYBBRRB", "YRBGB"
Output: 3
Explanation: RBYYBBRRB -> RBYY[Y]BBRRB -> RBBBRRB -> RRRB -> B -> B[B] -> BB[B] -> empty

Note:
You may assume that the initial row of balls on the table won’t have any 3 or more consecutive balls with the same color.
The number of balls on the table won't exceed 20, and the string represents these balls is called "board" in the input.
The number of balls in your hand won't exceed 5, and the string represents these balls is called "hand" in the input.
Both input strings will be non-empty and only contain characters 'R','Y','B','G','W'.

**/

public int findMinStep(String board, String hand) {
    Map<Character, Integer> input = new HashMap<>();
    for(int i = 0; i < hand.length(); i++) {
        char tmp = hand.charAt(i);
        input.put(tmp, input.getOrDefault(tmp, 0) + 1);
    }
    int res = dfs(board, input);
    return res == Integer.MAX_VALUE ? -1 : res;
}
public int dfs(String board, Map<Character, Integer> input) {
    board = preRemove(board);
    if(board.length() == 0) {
        return 0;
    }
    int res = Integer.MAX_VALUE;
    int preIndex = 0;
    for(int i = 0; i <= board.length(); i++) {
        if(i == board.length() || (i > 0 && board.charAt(i) != board.charAt(i - 1))) {
            int count = i - preIndex;
            char cur = board.charAt(preIndex);
            int req = 3 - count;
            if(input.containsKey(cur) && input.get(cur) >= req) {
                input.put(cur, input.get(cur) - req);
                int nextStep = dfs(board.substring(0, preIndex) + board.substring(i), input);
                if(nextStep < Integer.MAX_VALUE) {
                    res = Math.min(res, req + nextStep);
                }
                input.put(cur, input.get(cur) + req);
            }
            preIndex = i;
        }
    }
    return res;
}
public String preRemove(String s) {
    if(s.length() == 0) {
        return s;
    }
    StringBuilder sb = new StringBuilder();
    int pre = 0;
    for(int i = 0; i <= s.length(); i++) {
        if(i == s.length() || (i > 0 && s.charAt(i) != s.charAt(i - 1))) {
            int count = i - pre;
            if(count < 3) {
                for(int j = 0; j < count; j++) {
                    sb.append(s.charAt(pre));
                }
            }
            pre = i;
        }
    }
    if(s.length() == sb.length()) {
        return s;
    }
    return preRemove(sb.toString());
}
