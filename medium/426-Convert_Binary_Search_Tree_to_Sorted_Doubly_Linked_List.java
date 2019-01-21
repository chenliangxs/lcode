/**
Convert a BST to a sorted circular doubly-linked list in-place. Think of the left and right pointers as synonymous to the previous and next pointers in a doubly-linked list.

Let's take the following BST as an example, it may help you understand the problem better:





We want to transform this BST into a circular doubly linked list. Each node in a doubly linked list has a predecessor and successor. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of the last element is the first element.

The figure below shows the circular doubly linked list for the BST above. The "head" symbol means the node it points to is the smallest element of the linked list.





Specifically, we want to do the transformation in place. After the transformation, the left pointer of the tree node should point to its predecessor, and the right pointer should point to its successor. We should return the pointer to the first element of the linked list.

The figure below shows the transformed BST. The solid line indicates the successor relationship, while the dashed line means the predecessor relationship.



**/
public Node treeToDoublyList(Node root) {
    Node[] res = help(root);
    if(res[0] == null) {
        return null;
    }
    res[1].right = res[0];
    res[0].left = res[1];
    return res[0];
}
public Node[] help(Node root) {
    if(root == null) {
        return new Node[]{null, null};
    }
    Node[] leftRes = help(root.left);
    Node[] rightRes = help(root.right);
    if(leftRes[1] != null) {
        leftRes[1].right = root;
        root.left = leftRes[1];
    }
    if(rightRes[0] != null) {
        root.right = rightRes[0];
        rightRes[0].left = root;
    }
    Node[] res = new Node[2];
    res[0] = (leftRes[0] == null ? root : leftRes[0]);
    res[1] = (rightRes[1] == null ? root : rightRes[1]);
    return res;
}
