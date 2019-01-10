/**
Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.

Note:
A subtree must include all of its descendants.

Example:

Input: [10,5,15,1,8,null,7]

   10
   / \
  5  15
 / \   \
1   8   7

Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one.
             The return value is the subtree's size, which is 3.
Follow up:
Can you figure out ways to solve it with O(n) time complexity?
**/
//left -> -1 not bst -> return -1
//right -> -1, ... return -1
//left return num (max in left).
//right return num (min in right).
//checkout root.val with left right range.
//return range.
public int largestBSTSubtree(TreeNode root) {
    int[] global = new int[]{0};
    help(root, global);
    return global[0];
}
public int[] help(TreeNode root, int[] global) {
    if(root == null) {
        return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
    } else if(root.left == null && root.right == null) {
        global[0] = Math.max(global[0], 1);
        return new int[]{root.val, root.val, 1};
    }
    int[] leftReturn = help(root.left, global);
    int[] rightReturn = help(root.right, global);
    if(root.val > leftReturn[1] && root.val < rightReturn[0]) {
        global[0] = Math.max(global[0], leftReturn[2] + rightReturn[2] + 1);
        return new int[]{Math.min(leftReturn[0], root.val), Math.max(rightReturn[1], root.val), leftReturn[2] + rightReturn[2] + 1};
    }
    return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0};
}
