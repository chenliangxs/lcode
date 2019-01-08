/**

Additive number is a string whose digits can form additive sequence.

A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.

Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:

Input: "112358"
Output: true
Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
Example 2:

Input: "199100199"
Output: true
Explanation: The additive sequence is: 1, 99, 100, 199.
             1 + 99 = 100, 99 + 100 = 199
Follow up:
How would you handle overflow for very large input integers?
**/

public boolean isAdditiveNumber(String num) {
    for(int i = 1; i < num.length(); i++) {
        for(int j = i + 1; j < num.length(); j++) {
            long first = Long.parseLong(num.substring(0, i));
            long second = Long.parseLong(num.substring(i, j));
            if(dfs(first, second, new StringBuilder(), num)) {
                return true;
            }
        }
    }
    return false;
}
public boolean dfs(long first, long second, StringBuilder path, String num) {
    if(path.length() >= num.length()) {
        if(path.toString().equals(num)) {
            return true;
        } else {
            return false;
        }
    }
    path.append(first);
    return dfs(second, first + second, path, num);
}
