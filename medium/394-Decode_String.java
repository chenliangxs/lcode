/**
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
**/
public String decodeString(String s) {
    if(s.indexOf('[') == -1) {
        return s;
    }
    StringBuilder res = new StringBuilder();
    char[] chs = s.toCharArray();
    int leftIndex = 0;
    //int rightIndex = 0;
    String count = "";
    String str = "";
    int leftCount = 0;
    int rightCount = 0;
    for(int i = 0; i < chs.length; i++) {
        if(chs[i] >= '0' && chs[i] <= '9') {
            if(leftCount == 0) {
                if(str.length() > 0) {
                    res.append(str);
                    str = "";
                }
                count += chs[i];
            }
        } else if(chs[i] == '[') {
            if(leftCount == 0) {
                leftIndex = i + 1;
            }
            leftCount++;
        } else if(chs[i] == ']') {
            rightCount++;
            if(leftCount == rightCount) {
                String child = decodeString(s.substring(leftIndex, i));
                for(int r = 0; r < Integer.parseInt(count); r++) {
                    res.append(child);
                }
                count = "";
                str = "";
                leftIndex = i + 1;
                leftCount = 0;
                rightCount = 0;
            }
        } else {
            str += chs[i];
        }
    }
    if(leftIndex < chs.length) {
        res.append(s.substring(leftIndex));
    }
    return res.toString();
