/**
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

Example:

Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

Output: ["AAAAACCCCC", "CCCCCAAAAA"]

**/

public List<String> findRepeatedDnaSequences(String s) {
	char[] chs = s.toCharArray();
	List<String> res = new ArrayList<>();
	Set<String> added = new HashSet<>();
	Set<Integer> exist = new HashSet<>();
	int window = 0;
	for(int i = 0; i < chs.length; i++) {
		if(i > 9) {
			window = window >> 2;
		}	
		if(chs[i] == 'A') {
			window = window;
		} else if(chs[i] == 'C') {
			window = window | (1 << ((i < 10 ? i : 9) * 2)); 
		} else if(chs[i] == 'G') {
			window = window | (2 << ((i < 10 ? i : 9) * 2));
		} else {
			window = window | (3 << ((i < 10 ? i : 9) * 2));
		}
		if(i >= 9) {
			boolean flag = exist.add(window);
			if(!flag) {
				added.add(new String(chs, i - 9, 10));
			}
		}
	}
	for(String st : added) {
		res.add(st);
	}
	return res;
}














