/**
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

**/

public boolean exist(char[][] board, String word) {
	if(board.length == 0 || board[0].length == 0) {
		return false;
	}
	int m = board.length;
	int n = board[0].length;
	char[] path = word.toCharArray();
	for(int i = 0; i < m; i++) {
		for(int j = 0; j < n; j++) {
			boolean[][] visited = new boolean[m][n];
			if(dfs(i, j, board, 0, path, visited)) {
				return true;
			}
		}
	}
	return false;
}
public boolean dfs(int i, int j, char[][] board, int index, char[] path, boolean[][] visited) {
	if(index == path.length - 1) {
		if(board[i][j] == path[index]) {
			return true;
		} else {
			return false;
		}
	}
	if(board[i][j] != path[index]) {
		return false;
	}
	visited[i][j] = true;
	int[] dirs = new int[]{0, 1, 0, -1, 1, 0, -1, 0};
	for(int d = 0; d < dirs.length; d += 2) {
		int row = i + dirs[d];
		int col = j + dirs[d + 1];
		if(row >= 0 && row < board.length && col >= 0 && col < board[0].length && !visited[row][col]) {
			if(dfs(row, col, board, index + 1, path, visited)) {
				return true;
			}
		}
	}
	visited[i][j] = false;
	return false;
}





