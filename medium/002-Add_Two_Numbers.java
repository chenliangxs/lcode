You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

=============================================

public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                int sum = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                int sum = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l1 = l1.next;
            }else{
                int sum = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                cur.next = new ListNode(sum);
                cur = cur.next;
                l2 = l2.next;
            }
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }
