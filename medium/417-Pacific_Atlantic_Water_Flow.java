/**
Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
**/

public List<int[]> pacificAtlantic(int[][] matrix) {
	List<int[]> res = new ArrayList<>();
	if(matrix.length == 0 || matrix[0].length == 0) {
		return res;
	}
	int m = matrix.length;
	int n = matrix[0].length;
	boolean[][] pac = new boolean[m][n];
	boolean[][] alt = new boolean[m][n];
	for(int i = 0; i < m ;i++) {
		dfs(i, 0, pac, matrix);
		dfs(i, n - 1, alt, matrix);
	}
	for(int j = 0; j < n; j++) {
		dfs(0, j, pac, matrix);
		dfs(m - 1, j, alt, matrix);
	}
	for(int i = 0; i < m; i++) {
		for(int j = 0; j< n; j++) {
			if(pac[i][j] && alt[i][j]) {
				res.add(new int[]{i, j});
			}
		}
	}
	return res;
}
public void dfs(int row, int col, boolean[][] visited, int[][] matrix) {
	visited[row][col] = true;
	int[] dirs = new int[]{0, 1, 0, -1, 1, 0, -1, 0};
	for(int d = 0; d < dirs.length; d += 2) {
		int i = row + dirs[d];
		int j = col + dirs[d + 1];
		if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
			if(!visited[i][j] && matrix[i][j] >= matrix[row][col]) {
				dfs(i, j, visited, matrix);
			}
		}
	}
}