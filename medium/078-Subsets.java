/**
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
Accepted
303.8K
Submissions

**/

public List<List<Integer>> subsets(int[] nums) {
	List<Integer> path = new ArrayList<>();
	List<List<Integer>> res = new ArrayList<>();
	dfs(0, nums, path, res);
	return res;	
}
public void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> res) {
	if(index >= nums.length){
		res.add(new ArrayList<>(path));
		return;
	}
	dfs(index + 1, nums, path, res);
	path.add(nums[index]);
	dfs(index + 1, nums, path, res);
	path.remove(path.size() - 1);
}













