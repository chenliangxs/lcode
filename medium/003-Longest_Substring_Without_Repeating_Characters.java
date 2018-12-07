Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


===============================================

public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> positions = new HashMap<>();
        char[] chs = s.toCharArray();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < chs.length){
            if(positions.containsKey(chs[right])){
                int stop = positions.get(chs[right]);
                while(left <= stop){
                    positions.remove(chs[left++]);
                }
                positions.put(chs[right], right);
                right++;
            }else{
                maxLen = Math.max(maxLen, right - left + 1);
                positions.put(chs[right], right);
                right++;
            }
        }
        return maxLen;
    }