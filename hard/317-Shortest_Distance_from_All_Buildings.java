
/**
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
Example:

Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 7

Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
             the point (1,2) is an ideal empty land to build a house, as the total
             travel distance of 3+3+1=7 is minimal. So return 7.
Note:
There will be at least one building. If it is not possible to build such house according to the above rules, return -1.

================================================

**/
public int shortestDistance(int[][] grid) {
    if(grid.length == 0 || grid[0].length == 0) return -1;
    int m = grid.length;
    int n = grid[0].length;
    int[][] distance = new int[m][n];
    int[][] count = new int[m][n];
    int buildingCount = 0;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1){
                buildingCount++;
                bfs(i, j, m, n, grid, distance, count);
            }
        }
    }
    int minTotal = Integer.MAX_VALUE;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 0 && count[i][j] == buildingCount){
                minTotal = Math.min(minTotal, distance[i][j]);
            }
        }
    }
    return minTotal == Integer.MAX_VALUE ? -1 : minTotal;
}
public void bfs(int i, int j, int m, int n, int[][] grid, int[][] distance, int[][] count){
    boolean[][] visited = new boolean[m][n];
    Queue<int[]> q = new LinkedList<>();
    int[] dir = {1, 0, -1, 0, 0, 1, 0, -1};
    int step = 0;
    q.offer(new int[]{i, j});
    visited[i][j] = true;
    int lvlSize = 1;
    while(!q.isEmpty()){
        for(int k = 0; k < lvlSize; k++){
            int[] cur = q.poll();
            for(int d = 0; d < dir.length; d+=2){
                int row = cur[0] + dir[d];
                int col = cur[1] + dir[d + 1];
                if(row >= 0 && row < m && col >= 0 && col < n && !visited[row][col] && grid[row][col] == 0){
                    visited[row][col] = true;
                    q.offer(new int[]{row, col});
                }
            }
            distance[cur[0]][cur[1]] += step;
            count[cur[0]][cur[1]]++;
        }
        step++;
        lvlSize = q.size();
    }
}
