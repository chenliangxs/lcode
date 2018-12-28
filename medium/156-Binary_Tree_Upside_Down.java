/**
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

Example:

Input: [1,2,3,4,5]

    1
   / \
  2   3
 / \
4   5

Output: return the root of the binary tree [4,5,2,#,#,3,1]

   4
  / \
 5   2
    / \
   3   1
Clarification:

Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].

**/

public TreeNode upsideDownBinaryTree(TreeNode root) {
    if(root == null || (root.left == null && root.right == null)) {
        return root;
    }
    TreeNode curLeft = root.left;
    TreeNode curRight = root.right;
    root.left = null;
    root.right = null;
    TreeNode newRoot = upsideDownBinaryTree(curLeft);
    curLeft.left = curRight;
    curLeft.right = root;
    return newRoot;
}
