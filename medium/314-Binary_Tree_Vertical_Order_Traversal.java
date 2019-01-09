/**
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
**/
class Pair {
    TreeNode root;
    int order;
    public Pair(TreeNode root, int order) {
        this.root = root;
        this.order = order;
    }
}
public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> leftRes = new ArrayList<>();
    List<List<Integer>> rightRes = new ArrayList<>();
    if(root == null) {
        return leftRes;
    }
    Queue<Pair> que = new LinkedList<>();
    Pair start = new Pair(root, 0);
    que.offer(start);
    int lvlSize = 1;
    while(!que.isEmpty()) {
        for(int i = 0; i < lvlSize; i++) {
            Pair cur = que.poll();
            int order = cur.order;
            if(order >= 0) {
                if(order < rightRes.size()) {
                    rightRes.get(order).add(cur.root.val);
                } else {
                    rightRes.add(new ArrayList<Integer>());
                    rightRes.get(order).add(cur.root.val);
                }
            } else {
                int abs = Math.abs(order);
                if(abs <= leftRes.size()) {
                    leftRes.get(abs - 1).add(cur.root.val);
                } else {
                    leftRes.add(new ArrayList<Integer>());
                    leftRes.get(abs - 1).add(cur.root.val);
                }
            }
            if(cur.root.left != null) {
                Pair tmp = new Pair(cur.root.left, order - 1);
                que.offer(tmp);
            }
            if(cur.root.right != null) {
                Pair tmp = new Pair(cur.root.right, order + 1);
                que.offer(tmp);
            }
        }
        lvlSize = que.size();
    }
    Collections.reverse(leftRes);
    leftRes.addAll(rightRes);
    return leftRes;
}
