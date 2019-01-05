/**
You are given a m x n 2D grid initialized with these three possible values.

-1 - A wall or an obstacle.
0 - A gate.
INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Example: 

Given the 2D grid:

INF  -1  0  INF
INF INF INF  -1
INF  -1 INF  -1
  0  -1 INF INF
After running your function, the 2D grid should be:

  3  -1   0   1
  2   2   1  -1
  1  -1   2  -1
  0  -1   3   4
**/

public void wallsAndGates(int[][] rooms) {
	if(rooms.length == 0 || rooms[0].length == 0) {
		return;
	}
	int m = rooms.length;
	int n = rooms[0].length;
	for(int i = 0; i < m; i++) {
		for(int j = 0; j < n; j++) {
			if(rooms[i][j] == 0) {
				dfs(i, j, rooms, 0);
			}
		}
	}
	return;
}
public void dfs(int i, int j, int[][] rooms, int step) {
	if(step > rooms[i][j]) {
		return;
	}
	rooms[i][j] = Math.min(rooms[i][j], step);
	int[] dirs = new int[]{1, 0, -1, 0, 0, 1, 0, -1};
	for(int d = 0; d < dirs.length; d += 2) {
		int row = i + dirs[d];
		int col = j + dirs[d + 1];
		if(row >= 0 && col >= 0 && row < rooms.length && col < rooms[0].length) {
			if(rooms[row][col] > 0) {
				dfs(row, col, rooms, step + 1);
			}
		}
	}
}



















