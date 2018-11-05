Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"

=========================================================


public int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        char[] chs = s.toCharArray();
        int max = 0;
        for(int i=0; i<chs.length; i++){
            if(chs[i] == '('){
                stack.offerFirst(i);
            }else{
                if(!stack.isEmpty() && chs[stack.peekFirst()] == '('){
                    stack.pollFirst();
                    max = Math.max(max, i - (stack.isEmpty()?-1:stack.peekFirst()));
                }else{
                    stack.offerFirst(i);
                }
            }
        }
        return max;
    }