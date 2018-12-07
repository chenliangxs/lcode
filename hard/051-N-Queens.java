// The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.
//
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Example:
//
// Input: 4
// Output: [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],
//
//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
//
// ========================================

public List<List<String>> solveNQueens(int n) {
    List<List<String>> res = new ArrayList<>();
    if(n == 0) return res;
    int[] position = new int[n];
    Arrays.fill(position, -1);
    dfs(0, n, position, res);
    return res;
}
public void dfs(int index, int n, int[] position, List<List<String>> res){
    if(index == n){
        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(position[i] == j){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            board.add(sb.toString());
        }
        res.add(board);
        return;
    }
    for(int i = 0; i < n; i++){
        boolean allowed = true;
        for(int j = 0; j < index; j++){
            if(position[j] == i){
                allowed = false;
                break;
            }else if(Math.abs(index - j) == Math.abs(i - position[j])){
                allowed = false;
                break;
            }
        }
        if(allowed){
            position[index] = i;
            dfs(index + 1, n, position, res);
            position[index] = -1;
        }
    }
}
