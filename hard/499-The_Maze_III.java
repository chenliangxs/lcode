/**
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up (u), down (d), left (l) or right (r), but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction. There is also a hole in this maze. The ball will drop into the hole if it rolls on to the hole.

Given the ball position, the hole position and the maze, find out how the ball could drop into the hole by moving the shortest distance. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the hole (included). Output the moving directions by using 'u', 'd', 'l' and 'r'. Since there could be several different shortest ways, you should output the lexicographically smallest way. If the ball cannot reach the hole, output "impossible".

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The ball and the hole coordinates are represented by row and column indexes.



Example 1:

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (0, 1)

Output: "lul"

Explanation: There are two shortest ways for the ball to drop into the hole.
The first way is left -> up -> left, represented by "lul".
The second way is up -> left, represented by 'ul'.
Both ways have shortest distance 6, but the first way is lexicographically smaller because 'l' < 'u'. So the output is "lul".

Example 2:

Input 1: a maze represented by a 2D array

0 0 0 0 0
1 1 0 0 1
0 0 0 0 0
0 1 0 0 1
0 1 0 0 0

Input 2: ball coordinate (rowBall, colBall) = (4, 3)
Input 3: hole coordinate (rowHole, colHole) = (3, 0)

Output: "impossible"

Explanation: The ball cannot reach the hole.



Note:

There is only one ball and one hole in the maze.
Both the ball and hole exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and the width and the height of the maze won't exceed 30.

**/

public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
    int m = maze.length;
    int n = maze[0].length;
    boolean[][] visited = new boolean[m][n];
    StringBuilder path = new StringBuilder();
    String[] res = new String[]{""};
    int[] minStep = new int[]{Integer.MAX_VALUE};
    //visited[ball[0]][ball[1]] = true;
    dfs(maze, visited, ball, hole, 0, minStep, path, res);
    if(res[0].length() == 0) {
        return "impossible";
    }
    return res[0];
}
public void dfs(int[][] maze, boolean[][] visited, int[] ball, int[] hole, int curStep, int[] minStep, StringBuilder path, String[] res) {
    int[] dirs = new int[]{1, 0, 0, -1, 0, 1, -1, 0};
    //d, l, r, u
    int m = maze.length;
    int n = maze[0].length;
    visited[ball[0]][ball[1]] = true;
    for(int d = 0; d < dirs.length; d += 2) {
        int step = 0;
        int x = ball[0] + dirs[d];
        int y = ball[1] + dirs[d + 1];
        boolean flag = false;
        while(x < m && x >= 0 && y < n && y >= 0 && maze[x][y] == 0) {
            step++;
            if(x == hole[0] && y == hole[1]) {
                //check and return
                if(d == 0) {
                    path.append("d");
                } else if(d == 2) {
                    path.append("l");
                } else if(d == 4) {
                    path.append("r");
                } else {
                    path.append("u");
                }
                if(curStep + step < minStep[0]) {
                    minStep[0] = curStep + step;
                    res[0] = path.toString();
                }
                path.deleteCharAt(path.length() - 1);
                flag = true;
                break;
            }
            x += dirs[d];
            y += dirs[d + 1];
        }
        //wall or boundary
        x -= dirs[d];
        y -= dirs[d + 1];
        if(visited[x][y] || flag) {
            continue;
        }
        visited[x][y] = true;
        if(d == 0) {
            path.append("d");
        } else if(d == 2) {
            path.append("l");
        } else if(d == 4) {
            path.append("r");
        } else {
            path.append("u");
        }
        dfs(maze, visited, new int[]{x, y}, hole, curStep + step, minStep, path, res);
        //visited[x][y] = false;
        path.deleteCharAt(path.length() - 1);
    }
    visited[ball[0]][ball[1]] = false;
}
