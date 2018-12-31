/**
Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example:

Input:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Output: 4
**/

public int maximalSquare(char[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] len = new int[m][n];
    int globalMax = 0;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(matrix[i][j] == '0') {
                len[i][j] = 0;
            } else {
                if(i == 0 || j == 0) {
                    len[i][j] = 1;
                } else {
                    len[i][j] = Math.min(len[i - 1][j - 1], Math.min(len[i - 1][j], len[i][j - 1])) + 1;
                }
                globalMax = Math.max(globalMax, len[i][j]);
            }
        }
    }
    return globalMax * globalMax;
}
