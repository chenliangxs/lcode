/**
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Example 1:

Input: pattern = "abab", str = "redblueredblue"
Output: true
Example 2:

Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
Output: true
Example 3:

Input: pattern = "aabb", str = "xyzabcxzyabc"
Output: false

========================================================
**/
public boolean wordPatternMatch(String pattern, String str) {
    Map<Character, String> map = new HashMap<>();
    return dfs(pattern, str, map);
}
public boolean dfs(String pattern, String str, Map<Character, String> map){
    if(pattern.length() == 0 && str.length() == 0) return true;
    if(pattern.length() == 0 || str.length() == 0) return false;
    char chKey = pattern.charAt(0);
    if(map.containsKey(chKey)){
        String chVal = map.get(chKey);
        if(str.length() < chVal.length() || !chVal.equals(str.substring(0, chVal.length()))) return false;
        else return dfs(pattern.substring(1), str.substring(chVal.length()), map);
    }else{
        for(int i=1; i <= str.length(); i++){
            if(!map.containsValue(str.substring(0,i))){
                map.put(pattern.charAt(0), str.substring(0, i));
                if(dfs(pattern.substring(1), str.substring(i), map)) return true;
                map.remove(pattern.charAt(0));
            }
        }
        return false;
    }
}
===============================================
public boolean wordPatternMatch(String pattern, String str){
	Map<Character, String> map = new HashMap<>();
	return dfs(pattern, str, map);
}
public boolean dfs(String pattern, String str, Map<Character, String> map){
	if(pattern.length() == 0 && str.length() == 0){
		return true;
	}else if(pattern.length() == 0 || str.length() == 0){
		return false;
	}
	char ch = pattern.charAt(0);
	if(map.containsKey(ch)){
		String target = map.get(ch);
		if(str.indexOf(target) != 0){
			return false;
		}else{
			return dfs(pattern.substring(1), str.substring(target.length()), map);
		}
	}else{
		//boolean result = false;
		for(int i = 1; i <= str.length(); i++){
			String target = str.substring(0, i);
			if(!map.containsValue(target)){
				map.put(ch, target);
				if(dfs(pattern.substring(1), str.substring(i), map)){
					return true;
				}
				map.remove(ch);
			}
		}
		return false;
	}
}
