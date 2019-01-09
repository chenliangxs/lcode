/**
Given two sparse matrices A and B, return the result of AB.

You may assume that A's column number is equal to B's row number.

Example:

Input:

A = [
  [ 1, 0, 0],
  [-1, 0, 3]
]

B = [
  [ 7, 0, 0 ],
  [ 0, 0, 0 ],
  [ 0, 0, 1 ]
]

Output:

     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
**/
public int[][] multiply(int[][] A, int[][] B) {
    int ar = A.length;
    int ac = A[0].length;
    int br = B.length;
    int bc = B[0].length;
    int[][] res = new int[ar][bc];
    for(int i = 0; i < ar; i++) {
        for(int j = 0; j < ac; j++) {
            if(A[i][j] != 0) {
                for(int x = 0; x < bc; x++) {
                    res[i][x] += A[i][j] * B[j][x];
                }
            }
        }
    }
    return res;
}
