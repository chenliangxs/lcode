/**
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
Note:

1 is typically treated as an ugly number.
n does not exceed 1690.
**/

public int nthUglyNumber(int n) {
    int[] index = new int[3];
    int[] val = new int[]{2, 3, 5};
    int[] res = new int[n];
    res[0] = 1;
    for(int i = 1; i < n; i++) {
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < index.length; j++) {
            min = Math.min(min, res[index[j]] * val[j]);
        }
        for(int j = 0; j < index.length; j++) {
            if(min == res[index[j]] * val[j]) {
                index[j]++;
            }
        }
        res[i] = min;
    }
    return res[n - 1];
}
