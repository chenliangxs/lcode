/**
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids. How many unique paths would there be?

**/

public int uniquePathsWithObstacles(int[][] obstacleGrid){
	if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
		return 0;
	}		
	int m = obstacleGrid.length;
	int n = obstacleGrid[0].length;
	int[][] count = new int[m][n];
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(i == 0 && j == 0){
				count[i][j] = obstacleGrid[0][0] == 1 ? 0 : 1;
			}else if(i == 0){
				count[i][j] = (obstacleGrid[i][j] == 1 || count[i][j - 1] == 0) ? 0 : 1;
			}else if(j == 0){
				count[i][j] = (obstacleGrid[i][j] == 1 || count[i - 1][j] == 0) ? 0 : 1;
			}else{
				count[i][j] = (obstacleGrid[i][j] == 1) ? 0 : count[i - 1][j] + count[i][j - 1];
			}
		}
	}	
	return count[m - 1][n - 1];
}

