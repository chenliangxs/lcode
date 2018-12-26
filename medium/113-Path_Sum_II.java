/**

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]

**/
public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(root, 0, sum, path, res);
    return res;
}
public void dfs(TreeNode root, int curSum, int sum, List<Integer> path, List<List<Integer>> res){
    if(root == null) {
        return;
    }
    if(root.left == null && root.right == null) {
        if(root.val + curSum == sum) {
            path.add(root.val);
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            return;
        }else {
            return;
        }
    }
    path.add(root.val);
    dfs(root.left, curSum + root.val, sum, path, res);
    dfs(root.right, curSum + root.val, sum, path, res);
    path.remove(path.size() - 1);
}
