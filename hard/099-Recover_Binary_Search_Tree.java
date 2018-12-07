Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Example 1:

Input: [1,3,null,null,2]

   1
  /
 3
  \
   2

Output: [3,1,null,null,2]

   3
  /
 1
  \
   2
Example 2:

Input: [3,1,4,null,null,2]

  3
 / \
1   4
   /
  2

Output: [2,1,4,null,null,3]

  2
 / \
1   4
   /
  3
Follow up:

A solution using O(n) space is pretty straight forward.
Could you devise a constant space solution?

===================================================

public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.offerFirst(cur);
                cur = cur.left;
            }
            TreeNode temp = stack.pollFirst();
            if(pre != null){
                if(pre.val > temp.val && first == null){
                    first = pre;
                    second = temp;
                }else if(pre.val > temp.val && first != null){
                    int value = first.val;
                    first.val = temp.val;
                    temp.val = value;
                    return;
                }
            }
            pre = temp;
            cur = temp.right;
        }
        int value = first.val;
        first.val = second.val;
        second.val = value;
        return;
    }