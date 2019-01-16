/**
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example :

Input: [1,2,3]
Output: [1,2,4]
**/

public ListNode plusOne(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode first = pre;
    while(pre != null && pre.next != null) {
        if(pre.next.val != 9) {
            pre = pre.next;
            first = pre;
        } else {
            pre = pre.next;
        }
    }
    if(pre.val != 9) {
        pre.val = pre.val + 1;
        return dummy.next;
    }
    first.val = first.val + 1;
    boolean add = false;
    if(first == dummy) {
        add = true;
    }
    first = first.next;
    while(first != pre) {
        first.val = 0;
        first = first.next;
    }
    first.val = 0;
    return add ? dummy : dummy.next;
}
