/**

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.

**/

public int sumNumbers(TreeNode root) {
    int[] total = new int[]{0};
    dfs(0, root, total);
    return total[0];
}
public void dfs(int val, TreeNode root, int[] total) {
    if(root == null) {
        return;
    }
    if(root.left == null && root.right == null) {
        total[0] += (val * 10 + root.val);
        return;
    }
    dfs(val * 10 + root.val, root.left, total);
    dfs(val * 10 + root.val, root.right, total);
}
