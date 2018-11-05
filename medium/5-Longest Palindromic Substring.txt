Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"

=====================================

public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        int[] position = {0, 0};
        char[] chs = s.toCharArray();
        int maxLen = 0;
        boolean[][] isPali = new boolean[chs.length][chs.length];
        for(int i = chs.length - 1; i >= 0; i--){
            for(int j = i; j < chs.length; j++){
                if(i == j){
                    isPali[i][j] = true;
                }else if(i + 1 == j){
                    if(chs[i] == chs[j])
                        isPali[i][j] = true;
                }else{
                    if(chs[i] == chs[j]){
                        isPali[i][j] |= isPali[i + 1][j - 1];
                    }
                }
                if(isPali[i][j]){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        position[0] = i;
                        position[1] = j;
                    }
                }
            }
        }
        return s.substring(position[0], position[1] + 1);
    }