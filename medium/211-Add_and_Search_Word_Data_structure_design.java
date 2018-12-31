/**
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.

**/

class WordDictionary {

    Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        char[] chs = word.toCharArray();
        Node cur = root;
        for(int i = 0; i < chs.length; i++) {
            if(cur.children[chs[i] - 'a'] != null) {
                cur = cur.children[chs[i] - 'a'];
            } else {
                cur.children[chs[i] - 'a'] = new Node();
                cur = cur.children[chs[i] - 'a'];
            }
            if(i == chs.length - 1) {
                cur.isWord = true;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chs = word.toCharArray();
        Node cur = root;
        return help(cur, chs, 0);
    }
    public boolean help(Node p, char[] chs, int index) {
        if(p == null || index >= chs.length) {
            return false;
        }
        if(index == chs.length - 1) {
            if(chs[index] == '.') {
                for(int i = 0; i < 26; i++) {
                    if(p.children[i] != null && p.children[i].isWord) {
                        return true;
                    }
                }
                return false;
            }
            return p.children[chs[index] - 'a'] != null && p.children[chs[index] - 'a'].isWord;
        }
        if(chs[index] == '.') {
            for(int i = 0; i < 26; i++) {
                if(p.children[i] != null) {
                    if(help(p.children[i], chs, index + 1)) {
                        return true;
                    }
                }
            }
            return false;
        } else {
            return help(p.children[chs[index] - 'a'], chs, index + 1);
        }
    }

    class Node {
        boolean isWord;
        Node[] children;
        public Node() {
            isWord = false;
            children = new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
