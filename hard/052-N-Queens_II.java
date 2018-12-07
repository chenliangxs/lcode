// The n-queens puzzle is the problem of placing n queens on an n��n chessboard such that no two queens attack each other.
//
//
//
// Given an integer n, return the number of distinct solutions to the n-queens puzzle.
//
// =========================================


public int totalNQueens(int n) {
    int[] positions = new int[n];
    Arrays.fill(positions, -1);
    int[] res = {0};
    dfs(0, n, positions, res);
    return res[0];
}
public void dfs(int index, int n, int[] positions, int[] res){
    if(index == n){
        res[0]++;
        return;
    }
    for(int i = 0; i < n; i++){
        boolean allowed = true;
        for(int j = 0; j < index; j++){
            if(positions[j] == i){
                allowed = false;
                break;
            }else if(Math.abs(index - j) == Math.abs(i - positions[j])){
                allowed = false;
                break;
            }
        }
        if(allowed){
            positions[index] = i;
            dfs(index + 1, n, positions, res);
            positions[index] = -1;
        }
    }
}
