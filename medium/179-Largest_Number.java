/**
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

**/

public String largestNumber(int[] nums) {
	StringBuilder res = new StringBuilder();
	Integer[] obj = Arrays.stream(nums).boxed().toArray(Integer[]::new);
	Arrays.sort(obj, new Comparator<Integer>(){
		public int compare(Integer a, Integer b) {
			String n = a + "" + b;
			String m = b + "" + a;
			return m.compareTo(n);
		}
	});
	for(Integer n : obj) {
		res.append(((int)n));
	}
	while(res.length() >= 2 && res.charAt(0) == '0') {
		res.deleteCharAt(0);
	}
	return res.toString();
}















