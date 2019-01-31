/**
Implement a data structure supporting the following operations:

Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
Challenge: Perform all these in O(1) time complexity.
**/

class AllOne {

    class Node{
        int count;
        Set<String> keys;
        Node pre;
        Node next;
        public Node(){
            count = 0;
            keys = new HashSet<>();
            pre = null;
            next = null;
        }
    }

    Node data;
    Node tail;
    Map<String, Node> map;
    Map<Integer, Node> pos;

    /** Initialize your data structure here. */
    public AllOne() {
        data = new Node();
        tail = new Node();
        data.next = tail;
        tail.pre = data;
        map = new HashMap<>();
        pos = new HashMap<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!map.containsKey(key)) {
            if(!pos.containsKey(1)) {
                Node tmp = new Node();
                tmp.count = 1;
                tmp.keys.add(key);
                map.put(key, tmp);
                pos.put(1, tmp);
                Node next = data.next;
                data.next = tmp;
                tmp.pre = data;
                tmp.next = next;
                next.pre = tmp;
            } else {
                data.next.keys.add(key);
                map.put(key, data.next);
            }
        } else {
            Node tmp = map.get(key);
            int newCount = tmp.count + 1;
            tmp.keys.remove(key);
            Node pre = tmp.pre;
            Node next = tmp.next;
            if(tmp.keys.size() == 0) {
                //remove in data
                pre.next = next;
                next.pre = pre;
                //remove in pos
                pos.remove(tmp.count);
                tmp = pre;
            }
            //remove in map
            map.remove(key);
            if(!pos.containsKey(newCount)) {
                Node cur = new Node();
                cur.count = newCount;
                cur.keys.add(key);
                map.put(key, cur);
                pos.put(newCount, cur);
                tmp.next = cur;
                cur.pre = tmp;
                cur.next = next;
                next.pre = cur;
            } else {
                Node cur = pos.get(newCount);
                cur.keys.add(key);
                map.put(key, cur);
            }
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key)) {
            return;
        }
        Node cur = map.get(key);
        int newCount = cur.count - 1;
        cur.keys.remove(key);
        map.remove(key);
        Node pre = cur.pre;
        Node next = cur.next;
        if(cur.keys.size() == 0) {
            pre.next = next;
            next.pre = pre;
            pos.remove(cur.count);
            cur = next;
        }
        if(newCount == 0) {
            return;
        }
        if(!pos.containsKey(newCount)) {
            Node tmp = new Node();
            tmp.count = newCount;
            tmp.keys.add(key);
            map.put(key, tmp);
            pos.put(newCount, tmp);
            pre.next = tmp;
            tmp.pre = pre;
            tmp.next = cur;
            cur.pre = tmp;
        } else {
            Node tmp = pos.get(newCount);
            tmp.keys.add(key);
            map.put(key, tmp);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        Node max = tail.pre;
        if(max == data) {
            return "";
        }
        for(String s : max.keys) {
            return s;
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        Node min = data.next;
        if(min == tail) {
            return "";
        }
        for(String s : min.keys) {
            return s;
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
