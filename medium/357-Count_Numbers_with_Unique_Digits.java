/**
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:

Input: 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
             excluding 11,22,33,44,55,66,77,88,99
**/

public int countNumbersWithUniqueDigits(int n) {
    if(n == 0) {
        return 1;
    }
    int total = 0;
    for(int i = 1; i <= n; i++) {
        if(i == 1) {
            total += 10;
        } else {
            int j = 9;
            int count = 9;
            for(int k = 1; k < i; k++) {
                count *= j;
                j--;
            }
            total += count;
        }
    }
    return total;
}
