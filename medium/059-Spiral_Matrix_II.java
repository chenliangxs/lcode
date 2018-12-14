/**
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
**/

public int[][] generateMatrix(int n){
	int[][] res = new int[n][n];
	int r = 0;
	int c = 0;
	int minRow = 0;
	int minCol = 0;
	int maxRow = n - 1;
	int maxCol = n - 1;
	for(int i = 1; i <= n * n; i++){
		res[r][c] = i;
		if(c < maxCol && r == minRow){
			c++;
		}else if(r < maxRow && c == maxCol){
			r++;
		}else if(c > minCol && r == maxRow){
			c--;
		}else{
			r--;
		}
		if(r == minRow && c == minCol){
			minRow++;
			minCol++;
			maxRow--;
			maxCol--;
			r = minRow;
			c = minCol;
		}
	}
	return res;
}

















