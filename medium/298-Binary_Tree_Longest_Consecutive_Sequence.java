Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.

==================================================


public int longestConsecutive(TreeNode root) {
        int[] globalMax = {0};
        help(root, globalMax);
        return globalMax[0];
    }
    public int help(TreeNode root, int[] globalMax){
        if(root == null) return 0;
        int leftPath = help(root.left, globalMax);
        int rightPath = help(root.right, globalMax);
        int localMax = 1;
        if(leftPath != 0 && root.val + 1 == root.left.val){
            localMax = leftPath + 1;
        }
        if(rightPath != 0 && root.val + 1 == root.right.val){
            localMax = Math.max(localMax, rightPath + 1);
        }
        globalMax[0] = Math.max(globalMax[0], localMax);
        return localMax;
    }