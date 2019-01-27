/**
Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
**/
public List<List<Integer>> findSubsequences(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    if(nums.length == 0) {
        return res;
    }
    dfs(0, nums, path, res);
    return res;
}
public void dfs(int index, int[] nums, List<Integer> path, List<List<Integer>> res) {
    if(index >= nums.length) {
        return;
    }
    Set<Integer> visited = new HashSet<>();
    for(int i = index; i < nums.length; i++) {
        if(!visited.contains(nums[i]) && (path.size() == 0 || nums[i] >= path.get(path.size() - 1))) {
            visited.add(nums[i]);
            path.add(nums[i]);
            if(path.size() > 1) {
                res.add(new ArrayList<Integer>(path));
            }
            dfs(i + 1, nums, path, res);
            path.remove(path.size() - 1);
        }
    }
}
