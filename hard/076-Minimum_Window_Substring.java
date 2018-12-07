// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// Example:
//
// Input: S = "ADOBECODEBANC", T = "ABC"
// Output: "BANC"
//
// ========================================================

public String minWindow(String s, String t) {
    char[] chs = s.toCharArray();
    Map<Character, Integer> counts = new HashMap<>();
    for(int i=0; i<t.length(); i++){
        counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) + 1);
    }
    int minLen = Integer.MAX_VALUE;
    String res = "";
    int uniqleNo = counts.size();
    int left = 0;
    int right;
    for(right = 0; right < chs.length; right++){
        if(!counts.containsKey(chs[right])) continue;
        counts.put(chs[right], counts.get(chs[right]) - 1);
        if(counts.get(chs[right]) == 0) uniqleNo--;
        while(uniqleNo == 0 && left <= right){
            int curLen = right - left + 1;
            if(curLen < minLen){
                res = new String(chs, left, curLen);
                minLen = curLen;
            }
            if(!counts.containsKey(chs[left])) {
                left++;
            }else{
                counts.put(chs[left], counts.get(chs[left]) + 1);
                if(counts.get(chs[left++]) > 0){
                    uniqleNo++;
                    break;
                }
            }
        }
    }
    return res;
}
