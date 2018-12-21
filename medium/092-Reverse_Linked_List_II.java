/**
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ≤ m ≤ n ≤ length of list.

Example:

Input: 1->2->3->4->5->NULL, m = 2, n = 4
Output: 1->4->3->2->5->NULL

**/

public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    while(m > 1) {
        p = p.next;
        m--;
    }
    ListNode first = p;
    ListNode h = first.next;
    p = dummy;
    while(n > 0) {
        p = p.next;
        n--;
    }
    ListNode second = p.next;
    reverse(h, p);
    first.next = p;
    h.next = second;
    return dummy.next;
}
public void reverse(ListNode p, ListNode q){
    ListNode pre = null;
    ListNode cur = p;
    while(pre != q) {
        ListNode next = cur.next;
        cur.next = pre;
        pre = cur;
        cur = next;
    }
}
