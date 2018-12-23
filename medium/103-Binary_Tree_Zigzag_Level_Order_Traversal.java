/**
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

**/
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if(root == null) {
        return res;
    }
    Deque<TreeNode> q = new ArrayDeque<>();
    boolean left2Right = true;
    q.offerFirst(root);
    int lvlSize = 1;
    while(!q.isEmpty()) {
        List<Integer> lvl = new ArrayList<>();
        if(left2Right) {
            for(int i = 0; i < lvlSize; i++) {
                TreeNode cur = q.pollFirst();
                lvl.add(cur.val);
                if(cur.left != null) {
                    q.offerLast(cur.left);
                }
                if(cur.right != null) {
                    q.offerLast(cur.right);
                }
            }
            left2Right = false;
        } else {
            for(int i = 0; i < lvlSize; i++) {
                TreeNode cur = q.pollLast();
                lvl.add(cur.val);
                if(cur.right != null) {
                    q.offerFirst(cur.right);
                }
                if(cur.left != null) {
                    q.offerFirst(cur.left);
                }
            }
            left2Right = true;
        }
        lvlSize = q.size();
        res.add(lvl);
    }
    return res;
}

//sol 2
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, 0, res);
    return res;
}
public void dfs(TreeNode root, int lvl, List<List<Integer>> res){
    if(root==null){
        return;
    }
    if(lvl>=res.size()){
        List<Integer> temp = new ArrayList<Integer>();
        if(lvl%2==0){
            temp.add(root.val);
        }
        else{
            temp.add(0, root.val);
        }
        res.add(temp);
    }
    else{
        if(lvl%2==0){
            res.get(lvl).add(root.val);
        }
        else{
            res.get(lvl).add(0, root.val);
        }
    }
    dfs(root.left, lvl+1, res);
    dfs(root.right, lvl+1,res);
}
