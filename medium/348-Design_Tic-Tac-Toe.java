/**
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:
Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|
Follow up:
Could you do better than O(n2) per move() operation?
**/

class TicTacToe {

    char[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new char[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = (player == 1 ? 'X' : 'O');

        int rowCount = 0;
        for(int i = 0; i < board.length; i++) {
            if(player == 1 && board[row][i] == 'X') {
                rowCount++;
            } else if(player == 2 && board[row][i] == 'O') {
                rowCount++;
            }
        }
        if(rowCount == board.length) {
            return player;
        }
        int countCol = 0;
        for(int i = 0; i < board.length; i++) {
            if(player == 1 && board[i][col] == 'X') {
                countCol++;
            } else if(player == 2 && board[i][col] == 'O') {
                countCol++;
            }
        }
        if(countCol == board.length) {
            return player;
        }
        int posDiag = 0;
        int negDiag = 0;
        for(int i = 0; i < board.length; i++) {
            if(player == 1 && board[i][i] == 'X') {
                posDiag++;
            } else if(player == 2 && board[i][i] == 'O') {
                posDiag++;
            }
            if(player == 1 && board[i][board.length - 1 - i] == 'X') {
                negDiag++;
            } else if(player == 2 && board[i][board.length - 1- i] == 'O') {
                negDiag++;
            }
        }
        if(posDiag == board.length || negDiag == board.length) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


 // sol2

 //use 1 and -1. each row and each col has to sum to size. And plus 1 diag, 1 antidiag
