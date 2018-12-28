/**
Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?

**/

public void reverseWords(char[] str) {
	int left = 0;
	for(int i = 0; i < str.length; i++) {
		if(str[i] == ' ') {
			reverse(str, left, i - 1);
			left = i + 1;	
		}
		if(i == str.length - 1) {
			reverse(str, left, i);
		}
	}
	reverse(str, 0, str.length - 1);
}
public void reverse(char[] str, int left, int right) {
	while(left < right) {
		char tmp = str[left];
		str[left] = str[right];
		str[right] = tmp;
		left++;
		right--;
	}
}





















