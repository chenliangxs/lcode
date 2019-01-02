/**
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
**/

public List<List<String>> groupStrings(String[] strings) {
    List<List<String>> res = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for(String s : strings) {
        String key = getKey(s);
        if(!map.containsKey(key)) {
            map.put(key, new ArrayList<String>());
        }
        map.get(key).add(s);
    }
    for(String k : map.keySet()) {
        res.add(map.get(k));
    }
    return res;
}
public String getKey(String s) {
    char[] chs = s.toCharArray();
    if(s.length() == 0) {
        return null;
    }
    int step = chs[0] - 'a';
    for(int i = 0; i < chs.length; i++) {
        if(step > chs[i] - 'a') {
            chs[i] = (char)(chs[i] + 26 - step);
        } else {
            chs[i] = (char)(chs[i] - step);
        }
    }
    return new String(chs);
}
