/**
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:

Input: 4->2->1->3
Output: 1->2->3->4
Example 2:

Input: -1->5->3->4->0
Output: -1->0->3->4->5

**/

public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null && fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    ListNode second = slow.next;
    slow.next = null;
    ListNode first = sortList(head);
    second = sortList(second);
    return merge(first, second);
}
public ListNode merge(ListNode first, ListNode second) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    while(first != null || second != null) {
        if(first != null && second != null) {
            if(first.val < second.val) {
                pre.next = first;
                pre = pre.next;
                first = first.next;
            } else {
                pre.next = second;
                pre = pre.next;
                second = second.next;
            }
        } else if(first != null) {
            pre.next = first;
            pre = pre.next;
            first = first.next;
        } else {
            pre.next = second;
            pre = pre.next;
            second = second.next;
        }
    }
    return dummy.next;
}
