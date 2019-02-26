/**
For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

Now given a string representing n, you should return the smallest good base of n in string format.

Example 1:

Input: "13"
Output: "3"
Explanation: 13 base 3 is 111.


Example 2:

Input: "4681"
Output: "8"
Explanation: 4681 base 8 is 11111.


Example 3:

Input: "1000000000000000000"
Output: "999999999999999999"
Explanation: 1000000000000000000 base 999999999999999999 is 11.


Note:

The range of n is [3, 10^18].
The string representing n is always valid and will not have leading zeros.

**/

public String smallestGoodBase(String n) {
    long num = Long.parseLong(n);
    int max = (int)(Math.log(num + 1) / Math.log(2));
    for (int m = max; m > 2; m--) {
        long l = 2;
        long r = (long)(Math.pow(num, 1.0 / (m - 1)));
        while (l <= r) {
            long k = (l + r) / 2;
            long sum = 0;
            for (int i = 0; i < m; i++){
                sum = sum * k + 1;
            }
            if (num == sum) {
            return String.valueOf(k);
            } else if (num < sum) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
    }
    return String.valueOf(num - 1);
}
