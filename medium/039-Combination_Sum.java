
/**
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
**/
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(0, candidates, 0, target, path, res);
    return res;
}
public void dfs(int index, int[] candidates, int sum, int target, List<Integer> path, List<List<Integer>> res){
    if(sum == target){
        res.add(new ArrayList<>(path));
        return;
    }else if(sum > target){
        return;
    }
    for(int i = index; i < candidates.length; i++){
        path.add(candidates[i]);
        dfs(i, candidates, sum + candidates[i], target, path, res);
        path.remove(path.size() - 1);
    }
}
