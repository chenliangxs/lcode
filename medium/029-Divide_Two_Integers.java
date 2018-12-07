
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
=============================================

public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int res = 0;
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        while(m >= n){
            int tmp = 1;
            long k = n;
            while((k<<1) <= m){
                k <<= 1;
                tmp <<= 1;
            }
            res += tmp;
            m -= k;
        }
        return res * sign;
    }