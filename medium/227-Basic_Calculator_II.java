/**
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2 - 3/4"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.

**/

public int calculate(String s) {
    Deque<Integer> stack = new ArrayDeque<>();
    char[] chs = s.toCharArray();
    char sign = '+';
    int num = 0;
    for(int i = 0; i <= chs.length; i++) {
        if(i < chs.length && chs[i] <= '9' && chs[i] >= '0') {
            num = num * 10 + (chs[i] - '0');
        } else if(i == chs.length || chs[i] == '+' || chs[i] == '-' || chs[i] == '*' || chs[i] == '/') {
            if(sign == '+') {
                stack.offerFirst(num);
            } else if(sign == '-') {
                stack.offerFirst(-1 * num);
            } else if(sign == '*') {
                stack.offerFirst(stack.pollFirst() * num);
            } else if(sign == '/') {
                stack.offerFirst(stack.pollFirst() / num);
            }
            num = 0;
            sign = i < chs.length ? chs[i] : ' ';
        }
    }
    int res = 0;
    while(!stack.isEmpty()) {
        res += stack.pollFirst();
    }
    return res;
}
