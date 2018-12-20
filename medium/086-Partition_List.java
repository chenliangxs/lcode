/**

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

**/

public ListNode partition(ListNode head, int x) {
	ListNode first = new ListNode(0);
	ListNode second = new ListNode(0);
	ListNode f = first;
	ListNode s = second;
	ListNode p = head;
	while(p != null) {
		if(p.val < x) {
			f.next = p;
			f = f.next;
			p = p.next;
			f.next = null;
		} else {
			s.next = p;
			s = s.next;
			p = p.next;
			s.next = null;
		}
	}
	f.next = second.next;
	return first.next;
}