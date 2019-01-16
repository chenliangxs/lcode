/**
Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
Note: You can only put the bomb at an empty cell.

Example:

Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
Output: 3
Explanation: For the given grid,

0 E 0 0
E 0 W E
0 E 0 0

Placing a bomb at (1,1) kills 3 enemies.
**/
public int maxKilledEnemies(char[][] grid) {
    if(grid.length == 0 || grid[0].length == 0) {
        return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    int[][] countLeft = new int[m][n];
    int[][] countRight = new int[m][n];
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(grid[i][j] == 'W') {
                countLeft[i][j] = 0;
            } else if(grid[i][j] == 'E') {
                countLeft[i][j] = (j > 0 ? countLeft[i][j - 1] : 0) + 1;
            } else {
                countLeft[i][j] = (j > 0 ? countLeft[i][j - 1] : 0);
            }
        }
        for(int j = n - 1; j >= 0; j--) {
            if(grid[i][j] == 'W') {
                countRight[i][j] = 0;
            } else if(grid[i][j] == 'E') {
                countRight[i][j] = (j < n - 1 ? countRight[i][j + 1] : 0) + 1;
            } else {
                countRight[i][j] = (j < n - 1 ? countRight[i][j + 1] : 0);
            }
        }
    }
    int[][] countTop = new int[m][n];
    int[][] countBottom = new int[m][n];
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            if(grid[j][i] == 'W') {
                countTop[j][i] = 0;
            } else if(grid[j][i] == 'E') {
                countTop[j][i] = (j > 0 ? countTop[j - 1][i] : 0) + 1;
            } else {
                countTop[j][i] = (j > 0 ? countTop[j - 1][i] : 0);
            }
        }
        for(int j = m - 1; j >= 0; j--) {
            if(grid[j][i] == 'W') {
                countBottom[j][i] = 0;
            } else if(grid[j][i] == 'E') {
                countBottom[j][i] = (j < m - 1 ? countBottom[j + 1][i] : 0) + 1;
            } else {
                countBottom[j][i] = (j < m - 1 ? countBottom[j + 1][i] : 0);
            }
        }
    }
    int globalMax = 0;
    for(int i = 0; i < m; i++) {
        for(int j = 0; j < n; j++) {
            if(grid[i][j] == '0') {
                globalMax = Math.max(countLeft[i][j] + countRight[i][j] + countTop[i][j] + countBottom[i][j], globalMax);
            }
        }
    }
    return globalMax;
}
