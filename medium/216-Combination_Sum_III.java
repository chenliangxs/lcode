/**
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

**/

public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    if(k == 0 || n == 0) {
        return res;
    }
    dfs(1, 0, k, n, path, res);
    return res;
}
public void dfs(int index, int sum, int k, int n, List<Integer> path, List<List<Integer>> res) {
    if(sum > n || path.size() > k) {
        return;
    }
    if(sum == n && k == path.size()) {
        res.add(new ArrayList<Integer>(path));
        return;
    }
    for(int i = index; i < 10; i++) {
        path.add(i);
        dfs(i + 1, sum + i, k, n, path, res);
        path.remove(path.size() - 1);
    }
}
