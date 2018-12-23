/**
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

**/
public int numTrees(int n) {
    if(n == 0) {
        return 0;
    }
    int[] count = new int[n + 1];
    count[0] = 1;
    for(int i = 1; i <= n; i++) {
        for(int j = i - 1; j >= 0; j--) {
            count[i] += count[j] * count[i - j - 1];
        }
    }
    return count[n];
}
