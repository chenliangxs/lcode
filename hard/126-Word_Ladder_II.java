/**
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

==============================================================
**/
public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    Set<String> visited = new HashSet<>();
    Set<String> dict = new HashSet<>();
    for(String s:wordList) dict.add(s);
    path.add(beginWord);
    dfs(beginWord, endWord, path, visited, dict, res);
    return res;
}
public void dfs(String beginWord, String endWord, List<String> path, Set<String> visited, Set<String> dict, List<List<String>> res){
    if(res.size() > 0 && res.get(0).size() < path.size()) return;
    if(beginWord.equals(endWord)){
        //path.add(beginWord);
        if(res.size() == 0 || res.get(0).size() == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }else if(res.get(0).size() > path.size()){
            res.clear();
            res.add(new ArrayList<>(path));
            return;
        }else{
            return;
        }
    }
    char[] chs = beginWord.toCharArray();
    visited.add(beginWord);
    for(int i=0; i<chs.length; i++){
        for(char x='a'; x <= 'z'; x++){
            if(x == chs[i]) continue;
            else{
                char old = chs[i];
                chs[i] = x;
                String cur = new String(chs, 0, chs.length);
                if(!visited.contains(cur) && dict.contains(cur)){
                    path.add(cur);
                    dfs(cur, endWord, path, visited, dict, res);
                    path.remove(path.size() - 1);
                }
                chs[i] = old;
            }
        }
    }
    visited.remove(beginWord);
}


=====================================================
