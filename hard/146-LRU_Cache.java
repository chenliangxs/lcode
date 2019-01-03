/**
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 capacity );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

===================================================
**/

class LRUCache {

    int capacity;
    int count;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0, 0);
        head.right = tail;
        tail.left = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            Node pre = cur.left;
            Node next = cur.right;
            pre.right = next;
            next.left = pre;
            Node headNext = head.right;
            head.right = cur;
            cur.left = head;
            cur.right = headNext;
            headNext.left = cur;
            return cur.val;
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            cur.val = value;
            Node pre = cur.left;
            Node next = cur.right;
            pre.right = next;
            next.left = pre;
            Node headNext = head.right;
            cur.left = head;
            head.right = cur;
            cur.right = headNext;
            headNext.left = cur;
        }else{
            Node cur = new Node(key, value);
            count++;
            map.put(key, cur);
            if(count <= capacity){
                Node next = head.right;
                head.right = cur;
                cur.left = head;
                cur.right = next;
                next.left = cur;
            }else{
                Node temp = tail.left;
                map.remove(temp.key);
                temp.left.right = tail;
                tail.left = temp.left;
                temp.left = null;
                temp.right = null;
                Node headNext = head.right;
                head.right = cur;
                cur.left = head;
                cur.right = headNext;
                headNext.left = cur;
                count--;
            }
        }
    }
    class Node{
        int key;
        int val;
        Node left;
        Node right;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
