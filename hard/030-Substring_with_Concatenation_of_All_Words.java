/**
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodstudentgoodword",
  words = ["word","student"]
Output: []
========================================================
**/
public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> res = new ArrayList<>();
    if(s.length()==0 || words.length==0) return res;
    HashMap<String, Integer> wordCounts = new HashMap<>();
    for(String st:words){
        wordCounts.put(st, wordCounts.getOrDefault(st,0) + 1);
    }
    HashMap<String, Integer> check = new HashMap<>();
    int n = words.length;
    int len = words[0].length();
    char[] chs = s.toCharArray();
    for(int i=0; i + n*len<=chs.length; i++){
        int start = i;
        //System.out.println("=========="+start);
        check = (HashMap)wordCounts.clone();
        for(int j = 0; j < n; j++){
            String temp = s.substring(start, start+len);
            System.out.println(start+"===="+temp);
            System.out.println(check.containsKey(temp)?check.get(temp):"xx");
            if(!check.containsKey(temp)) break;
            else{
                if(check.get(temp) == 0) break;
                else check.put(temp, check.get(temp)-1);
            }
            start += len;
        }
        if(start == i+n*len) res.add(i);
        check.clear();
    }
    return res;
}
