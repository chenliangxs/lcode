/**
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
**/

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1tmp = reverse(l1);
        ListNode l2tmp = reverse(l2);
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        int carry = 0;
        while(l1tmp != null || l2tmp!= null) {
                if(l1tmp != null && l2tmp != null) {
                        int sum = (carry + l1tmp.val + l2tmp.val);
                        p.next = new ListNode(sum % 10);
                        p = p.next;
                        carry = sum / 10;
                        l1tmp = l1tmp.next;
                        l2tmp = l2tmp.next;
                } else if(l1tmp != null) {
                        int sum = (carry + l1tmp.val);
                        p.next = new ListNode(sum % 10);
                        p = p.next;
                        carry = sum / 10;
                        l1tmp = l1tmp.next;
                } else if(l2tmp != null) {
                        int sum = (carry + l2tmp.val);
                        p.next = new ListNode(sum % 10);
                        p = p.next;
                        carry = sum / 10;
                        l2tmp = l2tmp.next;
                }
        }
        if(carry != 0) {
                p.next = new ListNode(carry);
                p = p.next;
        }
		ListNode newHead = dummy.next;
        dummy.next = null;
        return reverse(newHead);
}

public ListNode reverse(ListNode head) {
        if(head == null || head.next == null) {
                return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
        }
        return pre;
}
