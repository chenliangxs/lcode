/**
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:

Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
**/

public ListNode rotateRight(ListNode head, int k){
	if(head == null || head.next == null){
		return head;
	}
	int len = 0;
	ListNode p = head;
	while(p != null){
		len++;
		p = p.next;
	}
	k = k % len;
	if(k == 0){
		return head;
	}
	p = head;
	ListNode q = head;
	while(k > 0){
		p = p.next;
		k--;
	}
	while(p.next != null){
		p = p.next;
		q = q.next;
	}
	ListNode res = q.next;
	q.next = null;
	p.next = head;
	return res;
}


















