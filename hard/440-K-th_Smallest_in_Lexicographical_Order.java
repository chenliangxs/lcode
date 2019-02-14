/**
Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.

Note: 1 ≤ k ≤ n ≤ 109.

Example:

Input:
n: 13   k: 2

Output:
10

Explanation:
The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
**/
public int findKthNumber(int n, int k) {
    int start = 1;
    k--;
    while(k > 0) {
        int count = getCount((long)start, (long)(start + 1), n);
        if(count <= k) {
            k -= count;
            start++;
        } else {
            k--;
            start = start * 10;
        }
    }
    return start;
}
public int getCount(long start, long end, int n) {
    int res = 0;
    while(start <= n) {
        res += Math.min(end, n + 1) - start;
        start *= 10;
        end *= 10;
    }
    return res;
}
