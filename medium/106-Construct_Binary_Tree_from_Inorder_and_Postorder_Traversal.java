/**

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7

**/

public TreeNode buildTree(int[] inorder, int[] postorder) {
    return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
}
public TreeNode build(int[] inorder, int inS, int inE, int[] postorder, int posS, int posE) {
    if(inS > inE || posS > posE) {
        return null;
    }
    if(inS == inE || posS == posE) {
        return new TreeNode(inorder[inS]);
    }
    TreeNode root = new TreeNode(postorder[posE]);
    int index = inS;
    for(; index <= inE; index++) {
        if(inorder[index] == postorder[posE]) {
            break;
        }
    }
    //leftCount = index - inS
    //rightCount = inE - (index + 1) + 1
    root.left = build(inorder, inS, index - 1, postorder, posS, posS + index - inS - 1);
    root.right = build(inorder, index + 1, inE, postorder, posS + index - inS, posE - 1);
    return root;
}
