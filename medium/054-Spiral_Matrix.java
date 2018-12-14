/**

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

**/

public List<Integer> spiralOrder(int[][] matrix){
	List<Integer> res = new ArrayList<>();
	if(matrix.length == 0 || matrix[0].length == 0){
		return res;
	}
	int i = 0;
	int j = 0;
	int minRow = 0;
	int minCol = 0;
	int maxRow = matrix.length - 1;
	int maxCol = matrix[0].length - 1;
	for(int x = 0; x < matrix.length * matrix[0].length; x++){
		res.add(matrix[i][j]);
		if(j < maxCol && i == minRow){
			j++;
		}else if(i < maxRow && j == maxCol){
			i++;
		}else if(j > minCol && i == maxRow){
			j--;
		}else{
			i--;
		}
		if(i == minRow && j== minCol){
			minRow++;
			minCol++;
			maxRow--;
			maxCol--;
			i = minRow;
			j = minCol;
		}
	}
	return res;
}





















