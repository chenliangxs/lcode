/**
A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".

Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.

For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.

Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.

Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.

Note:

Starting point is assumed to be valid, so it might not be included in the bank.
If multiple mutations are needed, all mutations during in the sequence must be valid.
You may assume start and end string is not the same.


Example 1:

start: "AACCGGTT"
end:   "AACCGGTA"
bank: ["AACCGGTA"]

return: 1


Example 2:

start: "AACCGGTT"
end:   "AAACGGTA"
bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]

return: 2


Example 3:

start: "AAAAACCC"
end:   "AACCCCCC"
bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]

return: 3
**/
public int minMutation(String start, String end, String[] bank) {
    Set<String> dict = new HashSet<>();
    for(String s : bank) {
        dict.add(s);
    }
    Set<String> visited = new HashSet<>();
    Queue<String> que = new LinkedList<>();
    visited.add(start);
    que.offer(start);
    int lvlSize = 1;
    int step = 0;
    while(!que.isEmpty()) {
        for(int i = 0; i < lvlSize; i++) {
            String cur = que.poll();
            if(cur.equals(end)) {
                return step;
            }
            List<String> followers = getNext(cur);
            for(String follower : followers) {
                if(dict.contains(follower) && !visited.contains(follower)) {
                    visited.add(follower);
                    que.offer(follower);
                }
            }
        }
        lvlSize = que.size();
        step++;
    }
    return -1;
}
public List<String> getNext(String str) {
    List<String> res = new ArrayList<>();
    char[] chs = str.toCharArray();
    Set<Character> set = new HashSet<>();
    set.add('A');
    set.add('C');
    set.add('G');
    set.add('T');
    for(int i = 0; i < chs.length; i++) {
        char tmp = chs[i];
        for(char ch : set) {
            if(tmp != ch) {
                chs[i] = ch;
                res.add(new String(chs));
            }
        }
        chs[i] = tmp;
    }
    return res;
}
