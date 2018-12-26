/**

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
**/

public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
}
public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
    if(preStart > preEnd || inStart > inEnd) {
        return null;
    }
    if(preStart == preEnd || inStart == inEnd) {
        return new TreeNode(preorder[preStart]);
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int target = preorder[preStart];
    int index = inStart;
    for(;index <= inEnd; index++) {
        if(inorder[index] == target) {
            break;
        }
    }
    //left count: index - inStart;
    //right count: inEnd - index;
    root.left = build(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index - 1);
    root.right = build(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);
    return root;
}
