/**
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

**/

public List<List<Integer>> subsetsWithDup(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	Arrays.sort(nums);
	dfs(0, nums, path, res);
	return res;
}
public void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> res) {
	if(index > nums.length) {
		return;
	}
	res.add(new ArrayList<Integer>(path));
	for(int i = index; i < nums.length; i++) {
		if(i == index || nums[i] != nums[i - 1]) {
			path.add(nums[i]);
			dfs(i + 1, nums, path, res);
			path.remove(path.size() - 1);
		}
	}
}










