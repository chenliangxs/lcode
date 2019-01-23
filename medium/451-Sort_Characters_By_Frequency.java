/**
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
**/
public String frequencySort(String s) {
	int[] count = new int[256];
	for(int i = 0; i < s.length(); i++) {
		count[s.charAt(i)]++;
	}
	Map<Character, Integer> map = new HashMap<>();
	for(int i = 0; i < 256; i++) {
		if(count[i] > 0) {
			map.put((char)(i), count[i]);
		}
	}
	PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
		public int compare(Map.Entry<Character, Integer> m1, Map.Entry<Character, Integer> m2) {
			return m2.getValue() - m1.getValue();
		}
	});
	
	for(Map.Entry<Character, Integer> e : map.entrySet()) {
		pq.offer(e);
	}
	
	StringBuilder res = new StringBuilder();
	while(!pq.isEmpty()) {
		Map.Entry<Character, Integer> cur = pq.poll();
		for(int i = 0; i < cur.getValue(); i++) {
			res.append(cur.getKey());
		}
	}
	return res.toString();
}

