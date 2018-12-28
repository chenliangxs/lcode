/**
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3

**/

public int numIslands(char[][] grid) {
    int count = 0;
    for(int i = 0; i < grid.length; i++) {
        for(int j = 0; j < grid[0].length; j++) {
            if(grid[i][j] == '1') {
                count++;
                dfs(i, j, grid);
            }
        }
    }
    return count;
}
public void dfs(int i, int j, char[][] grid) {
    grid[i][j] = '2';
    int[] dirs = {0, 1, 0, -1, 1, 0, -1, 0};
    for(int d = 0; d < dirs.length; d += 2) {
        int row = i + dirs[d];
        int col = j + dirs[d + 1];
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
            if(grid[row][col] == '1') {
                dfs(row, col, grid);
            }
        }
    }
}
