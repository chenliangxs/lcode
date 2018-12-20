/**
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3

**/

public ListNode deleteDuplicates(ListNode head) {
	ListNode dummy = new ListNode(0);
	ListNode cur = dummy;
	ListNode p = head;
	while(p != null) {
		ListNode q = p;
		while(q != null && q.next != null && q.val == q.next.val) {
			q = q.next;
		}
		if(q != p) {
			p = q.next;
		} else {
			cur.next = p;
			cur = cur.next;
			p = p.next;
			cur.next = null;
		}
	}
	return dummy.next;
}