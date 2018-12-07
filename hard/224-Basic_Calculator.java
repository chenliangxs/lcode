Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

Example 1:

Input: "1 + 1"
Output: 2
Example 2:

Input: " 2-1 + 2 "
Output: 3
Example 3:

Input: "(1+(4+5+2)-3)+(6+8)"
Output: 23

====================================================



====================================================

public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '('){
                res += num * sign;
                stack.offerFirst(res);
                stack.offerFirst(sign);
                res = 0;
                sign = 1;
                num = 0;
            }else if(ch == '+'){
                res += num * sign;
                num = 0;
                sign = 1;
            }else if(ch == '-'){
                res += num * sign;
                num = 0;
                sign = -1;
            }else if(ch == ')'){
                res += num * sign;
                int tempSign = stack.pollFirst();
                int tempNum = stack.pollFirst();
                res = tempNum + tempSign * res;
                num = 0;
                sign = 1;
            }
        }
        res += num * sign;
        return res;
    }