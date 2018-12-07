A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example:

Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
Output: [1,1,2,3]
Explanation:

Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

0 0 0
0 0 0
0 0 0
Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

1 0 0
0 0 0   Number of islands = 1
0 0 0
Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

1 1 0
0 0 0   Number of islands = 1
0 0 0
Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

1 1 0
0 0 1   Number of islands = 2
0 0 0
Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

1 1 0
0 0 1   Number of islands = 3
0 1 0
Follow up:

Can you do it in time complexity O(k log mn), where k is the length of the positions?

============================================

public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        int[] parent = new int[m * n];
        Arrays.fill(parent, -1);
        int total = 0;
        for(int i = 0; i < positions.length; i++){
            int x = positions[i][0];
            int y = positions[i][1];
            int cur = x * n + y;
            if(parent[cur] == -1){
                parent[cur] = cur;
                total++;
            }
            int[] dir = {0, 1, 0, -1, 1, 0, -1, 0};
            for(int d = 0; d < dir.length; d += 2){
                int row = x + dir[d];
                int col = y + dir[d + 1];
                if(row < 0 || row >= m || col < 0 || col >= n) continue;
                int neighbor = row * n + col;
                int rootNeighbor = getRoot(parent, neighbor);
                int rootCur = getRoot(parent, cur);
                if(rootNeighbor != -1 && rootCur != rootNeighbor){
                    total--;
                    setRoot(parent, rootCur, rootNeighbor);
                }
            }
            res.add(total);
        }
        return res;
    }
    public int getRoot(int[] parent, int index){
        if(parent[index] == -1) return -1;
        while(parent[index] != index){
            index = parent[index];
        }
        return index;
    }
    public void setRoot(int[] parent, int i, int j){
        if(i == j) return;
        else if(i < j) parent[j] = i;
        else parent[i] = j;
    }