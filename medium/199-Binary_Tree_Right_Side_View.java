/**
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

**/

public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    dfs(root, 0, res);
    return res;
}
public void dfs(TreeNode root, int depth, List<Integer> res) {
    if(root == null) {
        return;
    }
    if(depth >= res.size()) {
        res.add(root.val);
    }
    dfs(root.right, depth + 1, res);
    dfs(root.left, depth + 1, res);
}
