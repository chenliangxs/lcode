/**

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


**/

public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    Queue<String> q = new LinkedList<>();
    q.offer(beginWord);
    Set<String> visited = new HashSet<>();
    visited.add(beginWord);
    int step = 1;
    int lvlSize = 1;
    while(!q.isEmpty()) {
        for(int l = 0; l < lvlSize; l++) {
            String cur = q.poll();
            if(cur.equals(endWord)) {
                return step;
            }
            char[] chs = cur.toCharArray();
            for(int i = 0; i < chs.length; i++) {
                char origin = chs[i];
                for(char tmp = 'a'; tmp <= 'z'; tmp++) {
                    if(tmp != origin) {
                        chs[i] = tmp;
                        String candidate = new String(chs);
                        if(!visited.contains(candidate) && dict.contains(candidate)) {
                            visited.add(candidate);
                            q.offer(candidate);
                        }
                    }
                }
                chs[i] = origin;
            }
        }
        lvlSize = q.size();
        step++;
    }
    return 0;
}
