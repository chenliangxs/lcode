/**
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]

**/

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
	Set<Integer> visited = new HashSet<>();
        for(int i = index; i < nums.length; i++){
		if(!visited.contains(nums[i])){
			visited.add(nums[i]);
                	swap(nums, index, i);
                	path.add(nums[index]);
                	dfs(index + 1, nums, path, res);
                	path.remove(path.size() - 1);
                	swap(nums, index, i);	
		}
        }
}
public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
	nums[j] = tmp;
}
