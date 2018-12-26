/**
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.

Accepted

**/

public void solve(char[][] board) {
    if(board.length == 0 || board[0].length == 0) {
        return;
    }
    for(int i = 0; i < board.length; i++) {
        if(board[i][0] == 'O') {
            dfs(i, 0, board);
        }
        if(board[i][board[0].length - 1] == 'O') {
            dfs(i, board[0].length - 1, board);
        }
    }
    for(int j = 1; j < board[0].length - 1; j++) {
        if(board[0][j] == 'O') {
            dfs(0, j, board);
        }
        if(board[board.length - 1][j] == 'O') {
            dfs(board.length - 1, j, board);
        }
    }
    for(int i = 0; i < board.length; i++) {
        for(int j = 0; j < board[0].length; j++) {
            if(board[i][j] == 'Y') {
                board[i][j] = 'O';
            } else {
                board[i][j] = 'X';
            }
        }
    }
}
public void dfs(int i, int j, char[][] board) {
    board[i][j] = 'Y';
    int[] dirs = new int[]{1, 0, -1, 0, 0, 1, 0, -1};
    for(int d = 0; d < dirs.length; d += 2) {
        int row = i + dirs[d];
        int col = j + dirs[d + 1];
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
            if(board[row][col] == 'O') {
                dfs(row, col, board);
            }
        }
    }
}
