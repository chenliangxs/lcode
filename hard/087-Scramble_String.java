dfs

0  1   2 .........n-1 as separator between left part and right part


a b c

a | b c	a b | c

c b | a

isSame(left1, right2) || isScram(left1, right2)
&&
isSame(right1, left2) || isScram(left2, righ1)                     


Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Example 2:

Input: s1 = "abcde", s2 = "caebd"
Output: false

public boolean isScramble(String s1, String s2) {
        if(s1.length() == 0 && s2.length() == 0) return true;
        else if(s1.length() == 0 || s2.length() == 0) return false;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        return isScram(ch1, 0, ch1.length, ch2, 0, ch2.length);
    }
    boolean isScram(char[] ch1, int start1, int end1, char[] ch2, int start2, int end2){
        if(end1 - start1 != end2 - start2) return false;
        int[] check = new int[26];
        int length = end1 - start1;
        for(int i=0; i<length; i++){
            check[ch1[start1 + i] - 'a']++;
            check[ch2[start2 + i] - 'a']--;
        }
        for(int i = 0; i<26; i++){
            if(check[i] != 0) return false;
        }
        if(length <= 0) return true;
        else if(length == 1) return ch1[start1] == ch2[start2];
        for(int i = 1; i < length; i++){
            if((isScram(ch1, start1, start1 + i, ch2, start2, start2 + i) && isScram(ch1, start1 + i, end1, ch2, start2+i, end2)) || (isScram(ch1, start1, start1 + i, ch2, end2 - i, end2) && isScram(ch1, start1+i, end1, ch2, start2, end2 - i))) return true;
        }
        return false;
    }
  