/**
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example:

Input:

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

Output: 6

Explanation: Given three people living at (0,0), (0,4), and (2,2):
             The point (0,2) is an ideal meeting point, as the total travel distance
             of 2+2+2=6 is minimal. So return 6.

==============================================================
1 0 1 0 0 1
**/
public int minTotalDistance(int[][] grid) {
        int sum = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] vertical = new int[m];
        int[] horizontal = new int[n];
        for(int i = 0; i < m; i++){
            int total = 0;
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) total++;
            }
            vertical[i] = total;
        }
        for(int j = 0; j < n; j++){
            int total = 0;
            for(int i = 0; i < m; i++){
                if(grid[i][j] == 1) total++;
            }
            horizontal[j] = total;
        }
        sum += get1DMinDistance(vertical);
        sum += get1DMinDistance(horizontal);
        return sum;
    }
    public int get1DMinDistance(int[] array){
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            int total = 0;
            for(int j = 0; j < array.length; j++){
                if(array[j] != 0){
                    total += (array[j] * (Math.abs(j - i)));
                }
            }
            res = Math.min(res, total);
        }
        return res;
    }
