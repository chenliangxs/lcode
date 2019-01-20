/**
Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.
**/
public String removeKdigits(String num, int k) {
    if(num.length() <= k) {
        return "0";
    }
    Deque<Character> stack = new ArrayDeque<>();
    char[] chs = num.toCharArray();
    int removed = 0;
    for(int i = 0; i < chs.length; i++) {
        while(removed < k && !stack.isEmpty() && stack.peekFirst() > chs[i]) {
            stack.pollFirst();
            removed++;
            if(removed == k) {
                break;
            }
        }
        stack.offerFirst(chs[i]);
    }
    while(removed < k) {
        stack.pollFirst();
        removed++;
    }
    StringBuilder res = new StringBuilder();
    while(!stack.isEmpty()) {
        res.append(stack.pollFirst());
    }
    res.reverse();
    while(res.length() > 0 && res.charAt(0) == '0') {
        res.deleteCharAt(0);
    }
    return res.length() == 0 ? "0" : res.toString();
}
