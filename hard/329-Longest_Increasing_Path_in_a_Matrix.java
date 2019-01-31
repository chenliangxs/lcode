/**
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums =
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
]
Output: 4
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

**/

public int longestIncreasingPath(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) return 0;
    int max = 1;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] len = new int[m][n];
    for(int i = 0; i < m; i++){
        Arrays.fill(len[i], 1);
    }
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(len[i][j] == 1){
                len[i][j] = Math.max(len[i][j], dfs(i, j, matrix, len));
            }
            max = Math.max(max, len[i][j]);
        }
    }
    return max;
}
public int dfs(int i, int j, int[][] matrix, int[][] len){
    if(len[i][j] > 1){
        return len[i][j];
    }
    int[] dirs = new int[]{0, 1, 0, -1, 1, 0, -1, 0};
    int step = 1;
    for(int d = 0; d < dirs.length; d += 2){
        int row = i + dirs[d];
        int col = j + dirs[d + 1];
        if(row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length){
            if(matrix[row][col] > matrix[i][j]){
                step = Math.max(step, 1 + dfs(row, col, matrix, len));
            }
        }
    }
    len[i][j] = step;
    return step;
}
