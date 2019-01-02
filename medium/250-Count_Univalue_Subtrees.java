/**
Given a binary tree, count the number of uni-value subtrees.

A Uni-value subtree means all nodes of the subtree have the same value.

Example :

Input:  root = [5,1,5,5,5,null,5]

              5
             / \
            1   5
           / \   \
          5   5   5

Output: 4
**/

public int countUnivalSubtrees(TreeNode root) {
    int[] total = {0};
    dfs(root, total);
    return total[0];
}
public boolean dfs(TreeNode root, int[] total) {
    if(root == null) {
        return true;
    }
    boolean left = dfs(root.left, total);
    boolean right = dfs(root.right, total);
    if(left && right) {
        if(root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
            total[0]++;
            return true;
        } else if(root.left == null && root.right != null && root.right.val == root.val) {
            total[0]++;
            return true;
        } else if(root.right == null && root.left != null && root.left.val == root.val) {
            total[0]++;
            return true;
        } else if(root.left == null && root.right == null) {
            total[0]++;
            return true;
        }
    }
    return false;
}
