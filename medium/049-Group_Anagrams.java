/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
**/

public List<List<String>> groupAnagrams(String[] strs){
	List<List<String>> res = new ArrayList<>();
	Map<String, List<String>> map = new HashMap<>();
	for(String s : strs){
		char[] chs = s.toCharArray();
		Arrays.sort(chs);
		String key = new String(chs);
		if(!map.containsKey(key)){
			map.put(key, new ArrayList<String>());
		}
		map.get(key).add(s);
	}
	for(String s : map.keySet()){
		res.add(map.get(s));
	}	
	return res;
}






















