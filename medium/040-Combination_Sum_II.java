/**
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
**/

public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    Arrays.sort(candidates);
    dfs(0, candidates, 0, target, path, res);
    return res;
}
public void dfs(int index, int[] candidates, int sum, int target, List<Integer> path, List<List<Integer>> res){
    if(index > candidates.length || sum > target){
        return;
    }
    if(sum == target){
        res.add(new ArrayList<Integer>(path));
        return;
    }
    for(int i = index; i < candidates.length; i++){
        if(i == index || candidates[i] != candidates[i - 1]){
            path.add(candidates[i]);
            dfs(i + 1, candidates, sum + candidates[i], target, path, res);
            path.remove(path.size() - 1);
        }
    }
}
