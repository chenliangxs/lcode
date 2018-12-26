/**

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

root.right = flat(root.left);
leftLast.right = flat(root.right)
root.right
**/
public void flatten(TreeNode root) {
    help(root);
}
public TreeNode help(TreeNode root) {
    if(root == null) {
        return null;
    }
    TreeNode right = root.right;
    root.right = help(root.left);
    root.left = null;
    TreeNode p = root;
    while(p != null && p.right != null) {
        p = p.right;
    }
    p.right = help(right);
    return root;
}
