/**
Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Consider the following binary search tree:

     5
    / \
   2   6
  / \
 1   3
Example 1:

Input: [5,2,6,1,3]
Output: false
Example 2:

Input: [5,2,1,3,6]
Output: true
Follow up:
Could you do it using only constant space complexity?
**/

public boolean verifyPreorder(int[] preorder) {
    return check(preorder, 0, preorder.length - 1);
}
public boolean check(int[] preorder, int start, int end) {
    if(start >= end) {
        return true;
    }
    int rootVal = preorder[start];
    int index = start + 1;
    for(; index <= end; index++) {
        if(preorder[index] > rootVal) {
            break;
        }
    }
    int right = index + 1;
    for(; right <= end; right++) {
        if(preorder[right] < rootVal) {
            return false;
        }
    }
    return check(preorder, start + 1, index - 1) && check(preorder, index, end);
}
//sol2
public boolean verifyPreorder(int[] preorder) {
    Deque<Integer> stack = new ArrayDeque<>();
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    for(int i = 0; i < preorder.length; i++) {
        if(preorder[i] <= min) {
            return false;
        }
        if(stack.isEmpty() || preorder[i] < stack.peekFirst()) {
            max = preorder[i];
            stack.offerFirst(preorder[i]);
            continue;
        } else {
            while(!stack.isEmpty() && preorder[i] > stack.peekFirst()) {
                min = stack.pollFirst();
            }
            stack.offerFirst(preorder[i]);
            max = preorder[i];
        }
    }
    return true;
}
