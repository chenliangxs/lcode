/**
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	List<Integer> path = new ArrayList<>();
	dfs(0, nums, path, res);
	return res;	
}
public void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> res){
	if(index > nums.length){
		return;
	}
	if(index == nums.length){
		res.add(new ArrayList<>(path));
	}
	for(int i = index; i < nums.length; i++){
		swap(nums, index, i);
		path.add(nums[index]);
		dfs(index + 1, nums, path, res);
		path.remove(path.size() - 1);
		swap(nums, index, i);
	}	
}
public void swap(int[] nums, int i, int j){
	int tmp = nums[i];
	nums[i] = nums[j];
	nums[j] = tmp;
}


