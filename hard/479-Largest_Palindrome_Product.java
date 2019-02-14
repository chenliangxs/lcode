/**
Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.



Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987



Note:

The range of n is [1,8].
**/

public int largestPalindrome(int n) {
    int upper = (int)Math.pow(10, n) - 1;
    int lower = upper / 10;
    for(int i = upper; i > lower; i--) {
        long check = Long.parseLong(i + "" + reverse(i));
        for(long j = upper; j * j > check; j--) {
            if(check % j == 0) {
                return (int)(check % 1337);
            }
        }
    }
    return 9;
}
public String reverse(int n) {
    char[] chs = ("" + n).toCharArray();
    int i = 0;
    int j = chs.length - 1;
    while(i < j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
        i++;
        j--;
    }
    return new String(chs);
}
