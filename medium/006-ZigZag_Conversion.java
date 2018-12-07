The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

============================================

public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) return s;
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for(int i = 0; i < numRows; i++){
            if(i == 0 || i == numRows - 1){
                int j = i;
                while(j < chs.length){
                    sb.append(chs[j]);
                    j += 2*numRows - 2;
                }
            }else{
                int j = i;
                int k = 2*numRows - 2 - j;
                while(j < chs.length || k < chs.length){
                    if(j < chs.length) sb.append(chs[j]);
                    if(k < chs.length) sb.append(chs[k]);
                    j += 2*numRows - 2;
                    k += 2*numRows - 2;
                }
            }
        }
        return sb.toString();
    }