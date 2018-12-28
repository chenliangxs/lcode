/**
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

**/

public int rangeBitwiseAnd(int m, int n) {
    if(m == 0 || n == 0 || n / m >= 2) {
        return 0;
    }
    int res = 0;
    for(int i = 31; i >= 0; i--) {
        int maskOne = (m & (1 << i));
        int maskTwo = (n & (1 << i));
        if(maskOne == maskTwo) {
            res |= maskOne;
        } else {
            break;
        }
    }
    return res;
}
