Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?

======================================================

public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();
        TreeNode p = root;
        stack.offerFirst(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.peekFirst();
            if(cur.right != null && !visited.contains(cur.right)){
                stack.offerFirst(cur.right);
            }
            if(cur.left != null && !visited.contains(cur.left)){
                stack.offerFirst(cur.left);
            }
            if((cur.left == null || visited.contains(cur.left)) && (cur.right == null || visited.contains(cur.right))){
                res.add(cur.val);
                
                visited.add(stack.pollFirst());
            }
        }
        return res;
    }