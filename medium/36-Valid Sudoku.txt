
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

A partially filled sudoku which is valid.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

======================================

public boolean isValidSudoku(char[][] board) {
        Set<Integer> visited = new HashSet<>();
        //check rows
        for(int i = 0; i < 9; i++){
            visited.clear();
            for(int j = 0; j < 9; j++){
                char tmp = board[i][j];
                if(tmp != '.' && !visited.add(tmp - '0')) return false;
            }
        }
        //check cols
        for(int j = 0; j < 9; j++){
            visited.clear();
            for(int i = 0; i < 9; i++){
                char tmp = board[i][j];
                if(tmp != '.' && !visited.add(tmp - '0')) return false;
            }
        }
        //check 3x3
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                visited.clear();
                for(int m = 0; m < 3; m++){
                    for(int n = 0; n < 3; n++){
                        int row = m + i * 3;
                        int col = n + j * 3;
                        char tmp = board[row][col];
                        if(tmp != '.' && !visited.add(tmp - '0')) return false;
                    }
                }
            }
        }
        return true;
    }