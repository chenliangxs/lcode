/**
Given a binary tree, return the preorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
Follow up: Recursive solution is trivial, could you do it iteratively?

**/

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if(root == null) {
        return res;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.offerFirst(root);
    while(!stack.isEmpty()) {
        TreeNode cur = stack.pollFirst();
        res.add(cur.val);
        if(cur.right != null) {
            stack.offerFirst(cur.right);
        }
        if(cur.left != null) {
            stack.offerFirst(cur.left);
        }
    }
    return res;
}
