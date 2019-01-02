/**
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
**/

class WordDistance {

    Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> indexOne = map.get(word1);
        List<Integer> indexTwo = map.get(word2);
        int globalMin = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while(i < indexOne.size() && j < indexTwo.size()) {
            globalMin = Math.min(globalMin, Math.abs(indexOne.get(i) - indexTwo.get(j)));
            if(indexOne.get(i) <= indexTwo.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return globalMin;
    }
}
