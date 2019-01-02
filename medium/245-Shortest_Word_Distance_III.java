/**
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.
**/

public int shortestWordDistance(String[] words, String word1, String word2) {
    int indexOne = -1;
    int indexTwo = -1;
    int globalMin = words.length;
    for(int i = 0; i < words.length; i++) {
        if(word1.equals(word2) && words[i].equals(word1)) {
            indexTwo = indexOne;
            indexOne = i;
        } else if(words[i].equals(word1)) {
            indexOne = i;

        } else if(words[i].equals(word2)) {
            indexTwo = i;
        }
        if(indexOne != -1 && indexTwo != -1) {
            globalMin = Math.min(globalMin, Math.abs(indexTwo - indexOne));
        }
    }
    return globalMin;
}
