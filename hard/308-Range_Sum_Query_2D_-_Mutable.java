
/**
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 �� row2 and col1 �� col2.

==============================================
**/
class NumMatrix {

    int[][] matrix;
    int[][] sumMatrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        if(matrix.length > 0 && matrix[0].length > 0){
            sumMatrix = new int[matrix.length][matrix[0].length];
            initial();
        }
    }

    void initial(){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                sum += matrix[i][j];
                sumMatrix[i][j] = sum;
            }
        }
    }

    public void update(int row, int col, int val) {
        if(matrix.length == 0 || matrix[0].length == 0) return;
        int diff = val - matrix[row][col];
        matrix[row][col] = val;
        for(int j = col; j < matrix[0].length; j++){
            sumMatrix[row][j] += diff;
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int total = 0;
        for(int i = row1; i <= row2; i++){
            total += (sumMatrix[i][col2] - ((col1 == 0) ? 0 : sumMatrix[i][col1 - 1]));
        }
        return total;
    }
}
