Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.

=================================================

public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0) return 0;
        int max = 0;
        int left = 0;
        int total = 0;
        Map<Character, Integer> count = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            char chr = s.charAt(right);
            if(count.containsKey(chr)){
                count.put(chr, count.get(chr) + 1);
                //max = Math.max(max, right - left + 1);
            }else{
                while(total == k && left < right){
                    char chl = s.charAt(left);
                    count.put(chl, count.get(chl) - 1);
                    if(count.get(chl) == 0){
                        total--;
                        count.remove(chl);
                    }
                    left++;
                }
                total++;
                count.put(chr, 1);
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }