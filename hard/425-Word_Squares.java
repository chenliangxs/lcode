/**
Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
**/

class Solution {
    class Trie {
        String word;
        Trie[] children;
        public Trie() {
            word = "";
            children = new Trie[26];
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if(words.length == 0) {
            return res;
        }

        Trie root = buildTree(words);

        int n = words[0].length();
        Trie[] rows = new Trie[n];
        for(int i = 0; i < n; i++) {
            Trie tmp = root;
            rows[i] = tmp;
        }

        dfs(0, 0, n, rows, res);

        return res;
    }

    public void dfs(int r, int c, int n, Trie[] rows, List<List<String>> res) {
        if(r == n && c == n) {
            List<String> square = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                square.add(rows[i].word);
            }
            res.add(square);
            return;
        }
        if(c < n) {
            for(int i = 0; i < 26; i++) {
                if(rows[r].children[i] != null && rows[c].children[i] != null) {
                    Trie tmpC = rows[c];
                    Trie tmpR = rows[r];
                    rows[r] = rows[r].children[i];
                    if(r != c) {
                        rows[c] = rows[c].children[i];
                    }
                    dfs(r, c + 1, n, rows, res);
                    if(r != c) {
                        rows[c] = tmpC;
                    }
                    rows[r] = tmpR;
                }
            }
        } else{
            dfs(r + 1, r + 1, n, rows, res);
        }
    }

    public Trie buildTree(String[] words) {
        Trie root = new Trie();
        for(String word : words) {
            Trie p = root;
            char[] chs = word.toCharArray();
            for(int i = 0; i < chs.length; i++) {
                if(p.children[chs[i] - 'a'] == null) {
                    p.children[chs[i] - 'a'] = new Trie();
                }
                p = p.children[chs[i] - 'a'];
                if(i == chs.length - 1) {
                    p.word = word;
                }
            }
        }
        return root;
    }
}
