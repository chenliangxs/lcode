/**
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

=============================================================

int[2]

res[0]: global max
res[1]: pass up max. root, root+root left, root+root right
**/

public int maxPathSum(TreeNode root) {
    int[] res = new int[]{Integer.MIN_VALUE};
    getMax(root, res);
    return res[0];
}
public int getMax(TreeNode root, int[] res){
    if(root == null) return 0;
    int leftMax = getMax(root.left, res);
    int rightMax = getMax(root.right, res);
    int max = Math.max(root.val, Math.max(leftMax + root.val, rightMax + root.val));
    res[0] = Math.max(res[0], Math.max(max, root.val + leftMax + rightMax));
    return max;
}
