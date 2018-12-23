/**
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

**/

public List<TreeNode> generateTrees(int n) {
    if(n == 0){
        return new ArrayList<TreeNode>();
    }
    return generateBST(1, n);
}
public List<TreeNode> generateBST(int left, int right) {
    List<TreeNode> res = new ArrayList<>();
    if(left > right) {
        res.add(null);
    } else if(left == right) {
        res.add(new TreeNode(left));
    } else {
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generateBST(left, i - 1);
            List<TreeNode> rightTrees = generateBST(i + 1, right);
            for(TreeNode l : leftTrees) {
                for(TreeNode r : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
    }
    return res;
}
