/**

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

Example:

Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

Note:

Only constant extra memory is allowed.
You may not alter the values in the list's nodes, only nodes itself may be changed.


===============================================
**/


public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    ListNode p = head;
    int n = k;
    while(n > 1 && p != null){
        p = p.next;
        n--;
    }
    if(p == null) return head;
    ListNode next = p.next;
    p.next = null;
    dummy.next = reverse(head);
    head.next = reverseKGroup(next, k);
    return dummy.next;
}
public ListNode reverse(ListNode head){
    ListNode pre = null;
    ListNode cur = head;
    while(cur != null){
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
    return pre;
}
