/**
A string such as "word" contains the following abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Given a target string and a set of strings in a dictionary, find an abbreviation of this target string with the smallest possible length such that it does not conflict with abbreviations of the strings in the dictionary.

Each number or letter in the abbreviation is considered length = 1. For example, the abbreviation "a32bc" has length = 4.

Note:
In the case of multiple answers as shown in the second example below, you may return any one of them.
Assume length of target string = m, and dictionary size = n. You may assume that m ≤ 21, n ≤ 1000, and log2(n) + m ≤ 20.
Examples:
"apple", ["blade"] -> "a4" (because "5" or "4e" conflicts with "blade")

"apple", ["plain", "amber", "blade"] -> "1p3" (other valid answers include "ap3", "a3e", "2p2", "3le", "3l1").
**/

public String minAbbreviation(String target, String[] dictionary) {
    PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
        public int compare(String s1, String s2) {
            if(s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            return s1.length() - s2.length();
        }
    });
    getAbbreviation(0, target, new StringBuilder(), 0, pq);
    while(!pq.isEmpty()) {
        String cur = pq.poll();
        boolean flag = false;
        for(String st : dictionary) {
            if(isSame(cur, st)) {
                flag = true;
                break;
            }
        }
        if(!flag) {
            return cur;
        }
    }
    return target;
}
public void getAbbreviation(int index, String str, StringBuilder path, int count, PriorityQueue<String> pq) {
    int len = path.length();
    if(index == str.length()) {
        if(count > 0) {
            path.append(count);
            pq.offer(path.toString());
            path.setLength(len);
        } else {
            pq.offer(path.toString());
        }
        return;
    }
    getAbbreviation(index + 1, str, path, count + 1, pq);
    if(count > 0) {
        path.append(count);
    }
    path.append(str.charAt(index));
    getAbbreviation(index + 1, str, path, 0, pq);
    path.setLength(len);
    return;
}
public boolean isSame(String s, String t) {
    int i = 0;
    int j = 0;
    while(i < s.length() && j < t.length()) {
        char chs = s.charAt(i);
        char cht = t.charAt(j);
        if(!Character.isDigit(chs)) {
            if(chs == cht) {
                i++;
                j++;
            } else {
                return false;
            }
        } else {
            int count = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))) {
                count = count * 10 + (s.charAt(i) - '0');
                i++;
            }
            for(int x = 0; x < count; x++) {
                j++;
            }
        }
    }
    return i == s.length() && j == t.length();
}
