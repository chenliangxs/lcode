/**
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

Input: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:

Input: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
**/
//1. ask for child: not rob at child, rob at child
//2. root.val + not rob at left + not rob at right, rob at left + rob at right
//3. return local 1, local 2
public int rob(TreeNode root) {
    if(root == null) {
        return 0;
    }
    int[] res = search(root);
    return Math.max(res[0], res[1]);
}
public int[] search(TreeNode root) {
    if(root == null) {
        return new int[]{0, 0};
    }
    int[] leftRes = search(root.left);
    int[] rightRes = search(root.right);
    int[] res = new int[2];
    res[0] = leftRes[1] + rightRes[1] + root.val;
    res[1] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
    return res;
}
