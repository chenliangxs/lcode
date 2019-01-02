/**
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.
**/

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            int len = s.length();
            sb.append(len);
            sb.append("-");
            sb.append(s);
            sb.append("-");
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int index = 0;
        while(index < s.length()) {
            int len = 0;
            while(index < s.length() && Character.isDigit(s.charAt(index))) {
                len = len * 10 + (s.charAt(index) - '0');
                index++;
            }
            String tmp = s.substring(index + 1, index + len + 1);
            index = index + len + 2;
            res.add(tmp);
        }
        return res;
    }
}
