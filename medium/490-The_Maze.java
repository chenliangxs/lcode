/**
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.



Example 1:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true

Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false

Explanation: There is no way for the ball to stop at the destination.



Note:

There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
**/
public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    if(maze.length == 0 || maze[0].length == 0) {
        return false;
    }
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    return dfs(start, destination, visited, maze);
}
public boolean dfs(int[] start, int[] destination, boolean[][] visited, int[][] maze) {
    int row = start[0];
    int col = start[1];
    if(row == destination[0] && col == destination[1]) {
        return true;
    }
    visited[row][col] = true;
    int[] dirs = new int[]{1, 0, -1, 0, 0, 1, 0, -1};
    for(int i = 0; i < dirs.length; i += 2) {
        row = start[0];
        col = start[1];
        while(row + dirs[i] >= 0 && row + dirs[i] < maze.length && col + dirs[i + 1] >= 0 && col + dirs[i + 1] < maze[0].length && maze[row + dirs[i]][col + dirs[i + 1]] == 0) {
            row += dirs[i];
            col += dirs[i + 1];
        }
        if(!visited[row][col]) {
            if(dfs(new int[]{row, col}, destination, visited, maze)) {
                return true;
            }
        }
    }
    return false;
}
