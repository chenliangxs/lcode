/**
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

Example 1:

Input:
[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]

Output: "wertf"
Example 2:

Input:
[
  "z",
  "x"
]

Output: "zx"
Example 3:

Input:
[
  "z",
  "x",
  "z"
]

Output: ""

Explanation: The order is invalid, so return "".
Note:

You may assume all letters are in lowercase.
You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
If the order is invalid, return an empty string.
There may be multiple valid order of letters, return any one of them is fine.

===================================================
**/
public String alienOrder(String[] words) {
    Map<Character, Set<Character>> next = new HashMap<>();
    Map<Character, Integer> counts = new HashMap<>();
    for(String s:words){
        for(char ch:s.toCharArray()){
            counts.put(ch,0);
        }
    }
    for(int i=1; i<words.length; i++){
        findOrder(words[i-1], words[i], next, counts);
    }
    StringBuilder sb = new StringBuilder();
    Queue<Character> q = new LinkedList<>();
    Set<Character> visited = new HashSet<>();
    for(char ch : counts.keySet()){
        if(counts.get(ch) == 0) q.offer(ch);
    }
    while(q.size() > 0){
        char cur = q.poll();
        //counts.remove(cur);
        visited.add(cur);
        sb.append(cur);
        Set<Character> children = next.getOrDefault(cur,new HashSet<Character>());
        for(char child : children){
            if(visited.contains(child)) return "";
            counts.put(child, counts.get(child) - 1);
            if(counts.get(child) == 0){
                q.offer(child);
            }
        }
    }
    if(visited.size() != counts.size()) return "";
    return sb.toString();
}
public void findOrder(String s, String p, Map<Character, Set<Character>> next, Map<Character, Integer> counts){
    int i = 0;
    int j = 0;
    while(i < s.length() && j < p.length()){
        if(s.charAt(i) == p.charAt(j)){
            i++;
            j++;
        }else{
            if(next.containsKey(s.charAt(i))){
                if(next.get(s.charAt(i)).add(p.charAt(j))){
                    counts.put(p.charAt(j), counts.get(p.charAt(j)) + 1);
                }
                //counts.put(p.charAt(j), counts.getOrDefault(p.charAt(j), 0) + 1);
            }
            else{
                next.put(s.charAt(i), new HashSet<Character>());
                next.get(s.charAt(i)).add(p.charAt(j));
                //counts.put(p.charAt(j), counts.getOrDefault(p.charAt(j), 0) + 1);
                counts.put(p.charAt(j), counts.get(p.charAt(j)) + 1);
            }
            return;
        }
    }
}
