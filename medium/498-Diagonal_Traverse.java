/**
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.



Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Explanation:



Note:

The total number of elements of the given matrix will not exceed 10,000.
**/
public int[] findDiagonalOrder(int[][] matrix) {
    if(matrix.length == 0 || matrix[0].length == 0) {
        return new int[0];
    }
    int m = matrix.length;
    int n = matrix[0].length;
    int[] res = new int[m * n];
    boolean upDown = false;
    int i = 0;
    int j = 0;
    for(int x = 0; x < res.length; x++) {
        res[x] = matrix[i][j];
        if(upDown) {
            i++;
            j--;
        } else {
            i--;
            j++;
        }
        if(i < 0 && j < n) {
            i = 0;
            upDown = upDown ? false : true;
        } else if(j >= n) {
            j = n - 1;
            i += 2;
            upDown = upDown ? false : true;
        } else if(j < 0 && i < m) {
            j = 0;
            upDown = upDown ? false : true;
        } else if(i >= m) {
            i = m - 1;
            j += 2;
            upDown = upDown ? false : true;
        }
    }
    return res;
}
