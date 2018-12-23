/**
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
**/

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode p = root;
    while(p != null || !stack.isEmpty()) {
        while(p != null) {
            stack.offerFirst(p);
            p = p.left;
        }
        TreeNode cur = stack.pollFirst();
        res.add(cur.val);
        p = cur.right;
    }
    return res;
}
