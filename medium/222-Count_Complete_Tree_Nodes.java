/**
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

**/

public int countNodes(TreeNode root) {
    if(root == null) {
        return 0;
    }
    if(root.left == null && root.right == null) {
        return 1;
    }
    int leftHeight = 0;
    int rightHeight = 0;
    TreeNode p = root;
    TreeNode q = root;
    while(p != null) {
        p = p.left;
        leftHeight++;
    }
    while(q != null) {
        q = q.right;
        rightHeight++;
    }
    if(leftHeight == rightHeight) {
        return (1<<leftHeight) - 1;
    }
    return 1 + countNodes(root.left) + countNodes(root.right);
}
