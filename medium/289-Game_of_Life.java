/**

1 (<2) -> 0
1 (2,3) -> 1
1 (>3) -> 0
0 (3) -> 1

1 -> 3 : die after, but now is 1
0 -> 2: live after, but now is 0
1 -> 1: live after, but now is 1
0 -> 0: die after, but now is 0


According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.

Example:

Input:
[
  [0,1,0],
  [0,0,1],
  [1,1,1],
  [0,0,0]
]
Output:
[
  [0,0,0],
  [1,0,1],
  [0,1,1],
  [0,1,0]
]

=============================================================================

**/

public void gameOfLife(int[][] board) {
    int[] dirs = {0,1, 0,-1, 1,0, -1,0, 1,-1, 1,1, -1,-1, -1,1};
    int m = board.length;
    int n = board[0].length;
    for(int i = 0; i < board.length; i++){
        for(int j=0; j < board[0].length; j++){
            int count = 0;
            for(int d = 0; d < dirs.length; d+=2){
                int row = i + dirs[d];
                int col = j + dirs[d+1];
                if(row >=0 && row < m && col >=0 && col < n){
                    if(board[row][col] % 2 == 1){
                        count++;
                    }
                }
            }
            if(board[i][j] == 1){
                if(count < 2) board[i][j] = 3;
                else if(count == 2 || count == 3) board[i][j] = 1;
                else board[i][j] = 3;
            }else{
                if(count == 3) board[i][j] = 2;
                else board[i][j] = 0;
            }
        }
    }
    for(int i = 0; i<m; i++){
        for(int j=0; j<n; j++){
            board[i][j] = (board[i][j] == 3 || board[i][j] == 0) ? 0 : 1;
        }
    }
}
