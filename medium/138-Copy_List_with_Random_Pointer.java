/**
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
* class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
**/

public RandomListNode copyRandomList(RandomListNode head) {
    if(head == null) {
        return null;
    }
    Map<RandomListNode,RandomListNode> map = new HashMap<>();
    RandomListNode p = head;
    //RandomListNode dummy = new RandomListNode(0);
    //RandomListNode pp = dummy;
    while(p != null) {
        if(!map.containsKey(p)) {
            map.put(p, new RandomListNode(p.label));
        }
        if(p.next != null) {
            if(!map.containsKey(p.next)) {
                map.put(p.next, new RandomListNode(p.next.label));
            }
            map.get(p).next = map.get(p.next);
        }
        if(p.random != null) {
            if(!map.containsKey(p.random)) {
                map.put(p.random, new RandomListNode(p.random.label));
            }
            map.get(p).random = map.get(p.random);
        }
        p = p.next;
    }
    return map.get(head);
}
