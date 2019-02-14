/**
Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2  capacity );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
**/

class LFUCache {

    class Node{
        int key;
        int val;
        int freq;
        Node pre;
        Node next;
        public Node() {
            key = 0;
            val = 0;
            freq = 0;
            pre = null;
            next = null;
        }
    }

    Node head;
    Node tail;
    int size;
    int maxSize;
    Map<Integer, Node> map;

    public LFUCache(int capacity) {
        head = new Node();
        head.freq = Integer.MAX_VALUE;
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        size = 0;
        maxSize = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);
        cur.freq += 1;
        Node next = cur.next;
        Node pre = cur.pre;
        while(pre.freq <= cur.freq) {
            pre = pre.pre;
        }
        cur.pre.next = next;
        next.pre = cur.pre;

        //insert
        Node tmp = pre.next;
        pre.next = cur;
        cur.pre = pre;
        cur.next = tmp;
        tmp.pre = cur;
        return cur.val;
    }

    public void put(int key, int value) {
        if(maxSize == 0) {
            return;
        }
        if(!map.containsKey(key) && size >= maxSize) {
            Node last = tail.pre;
            map.remove(last.key);
            last.pre.next = tail;
            tail.pre = last.pre;
            last.pre = null;
            last.next = null;
            size--;
        }
        if(!map.containsKey(key)) {
            size++;
        }
        Node cur = map.getOrDefault(key, new Node());
        cur.key = key;
        cur.val = value;
        cur.freq += 1;
        map.put(key, cur);
        Node pre = cur.pre == null ? tail.pre : cur.pre;
        Node next = cur.next == null ? tail : cur.next;
        Node p = pre;
        while(p.freq <= cur.freq) {
            p = p.pre;
        }
        pre.next = next;
        next.pre = pre;
        //insert
        Node tmp = p.next;
        p.next = cur;
        cur.pre = p;
        cur.next = tmp;
        tmp.pre = cur;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
