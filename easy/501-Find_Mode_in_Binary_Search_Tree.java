/**

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.


For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2


return [2].

Note: If a tree has more than one mode, you can return them in any order.

Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

**/

public int[] findMode(TreeNode root) {
  TreeNode pre = null;
  Set<Integer> list = new HashSet<>();
  int maxCount = 0;
  int curCount = 0;
  TreeNode cur = root;
  Deque<TreeNode> stack = new ArrayDeque<>();
  while(!stack.isEmpty() || cur != null) {
      while(cur != null) {
          stack.offerFirst(cur);
          cur = cur.left;
      }
      TreeNode tmp = stack.pollFirst();
      if(pre == null || tmp.val != pre.val) {
          curCount= 1;
      } else {
          curCount++;
      }
      if(curCount == maxCount) {
          list.add(tmp.val);
      } else if(curCount > maxCount) {
          maxCount = curCount;
          list.clear();
          list.add(tmp.val);
      }
      pre = tmp;
      cur = tmp.right;
  }
  int[] res = new int[list.size()];
  int index = 0;
  for(int x : list) {
      res[index++] = x;
  }
  return res;
}

class Solution {
  TreeNode pre = null;
  public int[] findMode(TreeNode root) {
      Set<Integer> set = new HashSet<>();
      help(root, new int[]{0}, new int[]{0}, set);
      int[] res = new int[set.size()];
      int index = 0;
      for(int x : set) {
          res[index++] = x;
      }
      return res;
  }
  public void help(TreeNode root, int[] count, int[] max, Set<Integer> set) {
      if(root == null) return;
      help(root.left, count, max, set);
      if(pre == null || root.val != pre.val) {
          count[0] = 1;
      } else {
          count[0]++;
      }
      if(count[0] == max[0]) {
          set.add(root.val);
      } else if(count[0] > max[0]) {
          max[0] = count[0];
          set.clear();
          set.add(root.val);
      }
      pre = root;
      help(root.right, count, max, set);
  }
}
