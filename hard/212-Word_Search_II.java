/**
x 2 x
x 1 x
x x x

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input:
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
===========================================
**/

public List<String> findWords(char[][] board, String[] words) {
    List<String> res = new ArrayList<>();
    Set<String> set = new HashSet<>();
    StringBuilder path = new StringBuilder();
    Node root = buildTree(words);
    for(int i=0; i<board.length; i++){
        for(int j=0; j<board[0].length; j++){
            dfs(board, i, j, root, path, set);
        }
    }
    for(String st:set) res.add(st);
    return res;
}
public void dfs(char[][] board, int row, int col, Node root, StringBuilder path, Set<String> set){
    if(root.isWord){
        set.add(path.toString());
        //return;
    }
    if(row <0 || row >= board.length || col <0 || col >= board[0].length) return;
    if(board[row][col] == '.') return;
    int[] dir = new int[]{0,1, 0,-1, 1,0, -1,0};
    Node cur = root.children[board[row][col] - 'a'];
    char origin = board[row][col];
    if(cur!=null){
        board[row][col] = '.';
        path.append(origin);
        for(int d = 0; d < dir.length; d+=2){
            int i = row + dir[d];
            int j = col + dir[d+1];
            dfs(board, i, j, cur, path, set);
        }
        path.deleteCharAt(path.length() - 1);
        board[row][col] = origin;
    }
}
public Node buildTree(String[] words){
    Node root = new Node('0');
    for(String s:words){
        char[] chs = s.toCharArray();
        Node cur = root;
        for(int i=0; i<chs.length; i++){
            if(cur.children[chs[i] - 'a'] != null){
                cur = cur.children[chs[i] - 'a'];
            }else{
                Node temp = new Node(chs[i]);
                cur.children[chs[i] - 'a'] = temp;
                cur = cur.children[chs[i] - 'a'];
            }
            if(i == chs.length - 1){
                cur.isWord = true;
            }
        }
    }
    return root;
}
class Node{
    char val;
    Node[] children;
    boolean isWord;
    public Node(char ch){
        val = ch;
        children = new Node[26];
        isWord = false;
    }
}
