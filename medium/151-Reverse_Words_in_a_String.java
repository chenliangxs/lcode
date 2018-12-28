/**

Given an input string, reverse the string word by word.

Example:

Input: "the sky is blue",
Output: "blue is sky the".
Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
Follow up: For C programmers, try to solve it in-place in O(1) space.

**/

public String reverseWords(String s) {
    char[] chs = s.toCharArray();
    int index = 0;
    int right = 0;
    while(right < chs.length) {
        if(chs[right] != ' ' || (right < chs.length - 1 && chs[right + 1] != ' ')) {
            chs[index++] = chs[right++];
        } else {
            right++;
        }
    }
    int left = 0;
    right = 0;
    while(right < index) {
        if(right > 0 && chs[right] == ' ' && chs[right - 1] != ' ') {
            reverse(left, right - 1, chs);
        } else if(right > 0 && chs[right] != ' ' && chs[right - 1] == ' '){
            left = right;
        }
        right++;
    }
    reverse(left, right - 1, chs);
    reverse(0, index - 1, chs);
    String res = new String(chs, 0, index);
    return res.trim();
}
public void reverse(int left, int right, char[] chs) {
    while(left <= right) {
        char tmp = chs[left];
        chs[left] = chs[right];
        chs[right] = tmp;
        left++;
        right--;
    }
}
