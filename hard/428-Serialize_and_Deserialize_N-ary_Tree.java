/**
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following 3-ary tree







as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.



Note:

N is in the range of [1, 1000]
Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
**/

/**
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            Node cur = que.poll();
            sb.append(cur.val);
            sb.append("-");
            sb.append(cur.children.size());
            sb.append(",");
            for(Node next : cur.children) {
                que.offer(next);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }

        String[] strs = data.split(",");
        Map<Node, Integer> count = new HashMap<>();
        int index = 0;
        Queue<Node> que = new LinkedList<>();

        String[] first = strs[0].split("-");
        Node root = new Node(Integer.parseInt(first[0]), new ArrayList<Node>());
        count.put(root, Integer.parseInt(first[1]));
        que.offer(root);
        index++;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int n = count.get(cur);
            for(int i = 0; i < n; i++) {
                String[] nextInfo = strs[index++].split("-");
                Node next = new Node(Integer.parseInt(nextInfo[0]), new ArrayList<Node>());
                count.put(next, Integer.parseInt(nextInfo[1]));
                cur.children.add(next);
                que.offer(next);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
