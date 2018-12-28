/**

Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

**/

class Trie {
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] chs = word.toCharArray();
        Node cur = root;
        for(int i = 0; i < chs.length; i++) {
            if(cur.children[chs[i] - 'a'] == null) {
                cur.children[chs[i] - 'a'] = new Node();
            }
            cur = cur.children[chs[i] - 'a'];
            if(i == chs.length - 1) {
                cur.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        Node cur = root;
        for(int i = 0; i < chs.length; i++) {
            if(cur.children[chs[i] - 'a'] == null) {
                return false;
            } else {
                cur = cur.children[chs[i] - 'a'];
            }
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chs = prefix.toCharArray();
        Node cur = root;
        for(int i = 0; i < chs.length; i++) {
            if(cur.children[chs[i] - 'a'] == null) {
                return false;
            } else {
                cur = cur.children[chs[i] - 'a'];
            }
        }
        return true;
    }

    class Node {
        boolean isWord;
        Node[] children;
        public Node(){
            isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
