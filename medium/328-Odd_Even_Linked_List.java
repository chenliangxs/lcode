/**

Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example 1:

Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL
Example 2:

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
Note:

The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ...

**/

public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    ListNode first = new ListNode(0);
    ListNode second = new ListNode(0);
    ListNode p1 = first;
    ListNode p2 = second;
    ListNode cur = head;
    int count = 1;
    while(cur != null) {
        if(count % 2 == 0) {
            p2.next = cur;
            p2 = p2.next;
            cur = cur.next;
            p2.next = null;
        } else {
            p1.next = cur;
            p1 = p1.next;
            cur = cur.next;
            p1.next = null;

        }
        count++;
    }
    p1.next = second.next;
    return first.next;
}
//2
public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null) {
        return head;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode sec = head.next;
    while(even != null && even.next != null) {
        odd.next = even.next;
        even.next = odd.next.next;
        odd = odd.next;
        even = even.next;
    }
    odd.next = sec;
    return head;
}
