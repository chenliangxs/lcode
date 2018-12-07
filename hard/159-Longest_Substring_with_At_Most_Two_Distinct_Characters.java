Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.


======================================================

public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) return s.length();
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0; 
        for(int i=0; i<chs.length; i++) {
            if(map.containsKey(chs[i])) {
                map.put(chs[i], map.get(chs[i]) + 1);
                maxLen = Math.max(maxLen, i - left + 1);
            }else{
                map.put(chs[i], 1);
                if(map.size() <= 2){
                    maxLen = Math.max(maxLen, i - left + 1);
                }else{
                    while(left <= i){
                        map.put(chs[left], map.get(chs[left]) - 1);
                        if(map.get(chs[left]) == 0){
                            map.remove(chs[left]);
                            left++;
                            break;
                        }else{
                            left++;
                        }
                    }
                }
            }
        }
        maxLen = Math.max(maxLen, chs.length - left);
        return maxLen;
    }