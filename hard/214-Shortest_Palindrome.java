/**
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: "abcd"
Output: "dcbabcd"

======================================
from 0 position, longest palidrome

=======================================
**/

public String shortestPalindrome(String s) {
        char[] chs = s.toCharArray();
        int left = 0;
        int right = chs.length -1;
        int end = chs.length - 1;
        while(left < right){
            if(chs[left] == chs[right]){
                left++;
                right--;
            }else{
                left = 0;
                end--;
                right = end;
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(end+1));
        return sb.reverse().toString() + s;
    }
