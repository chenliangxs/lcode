Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.


A sudoku puzzle...


...and its solution numbers marked in red.

Note:

The given board contain only digits 1-9 and the character '.'.
You may assume that the given Sudoku puzzle will have a single unique solution.
The given board size is always 9x9.


========================================

public void solveSudoku(char[][] board) {
        solve(board);
	    return;
    }
    public boolean solve(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(int k = 1; k < 10; k++){
                        if(isValid(board, i, j, k)){
                            board[i][j] = (char)(k + '0');
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isValid(char[][] board, int row, int col, int k){
        for(int i = 0; i < 9; i++){
            if(board[i][col] - '0' == k) return false;
        }
        for(int j = 0; j < 9; j++){
            if(board[row][j] - '0' == k) return false;
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int m = i + (row / 3) * 3;
                int n = j + (col / 3) * 3;
                if(board[m][n] - '0' == k) return false;
            }
        }
        return true;
    }
