/**
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.



Example:

Input: [1,2,3,4,5]

          1
         / \
        2   3
       / \
      4   5

Output: [[4,5,3],[2],[1]]


Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         /
        2


2. Now removing the leaf [2] would result in this tree:

          1


3. Now removing the leaf [1] would result in the empty tree:

          []
**/
public List<List<Integer>> findLeaves(TreeNode root) {
    //dfs down -> up
    //1. ask for left height, right height, find height of cur node.
    //2. add cur node to list index max(rightheight, leftheight)
    //3. return max
    List<List<Integer>> res = new ArrayList<>();
    dfs(root, res);
    return res;
}
public int dfs(TreeNode root, List<List<Integer>> res) {
    if(root == null) {
        return 0;
    }
    if(root.left == null && root.right == null) {
        if(res.size() == 0) {
            res.add(new ArrayList<Integer>());
        }
        res.get(0).add(root.val);
        return 1;
    }
    int leftHeight = dfs(root.left, res);
    int rightHeight = dfs(root.right, res);
    int curHeight = Math.max(leftHeight, rightHeight);
    if(res.size() <= curHeight) {
        res.add(new ArrayList<Integer>());
    }
    res.get(curHeight).add(root.val);
    return curHeight + 1;
}
