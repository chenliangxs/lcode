/**
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

**/

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if(root == null) {
        return res;
    }
    q.offer(root);
    int lvlSize = 1;
    while(!q.isEmpty()) {
        List<Integer> lvl = new ArrayList<>();
        for(int i = 0; i < lvlSize; i++) {
            TreeNode cur = q.poll();
            lvl.add(cur.val);
            if(cur.left != null) {
                q.offer(cur.left);
            }
            if(cur.right != null) {
                q.offer(cur.right);
            }
        }
        res.add(lvl);
        lvlSize = q.size();
    }
    return res;
}
