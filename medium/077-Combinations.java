/**
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

**/

public List<List<Integer>> combine(int n, int k) {
	List<Integer> path = new ArrayList<>();
	List<List<Integer>> res = new ArrayList<>();
	dfs(1, n, k, path, res);
	return res;
}
public void dfs(int index, int n, int k, List<Integer> path, List<List<Integer>> res) {
	if(index > n + 1 || path.size() > k) {
		return;
	}
	if(path.size() == k) {
		res.add(new ArrayList<Integer>(path));
		return;
	}
	for(int i = index; i <= n; i++) {
		path.add(i);
		dfs(i + 1, n, k, path, res);
		path.remove(path.size() - 1);
	}
}















