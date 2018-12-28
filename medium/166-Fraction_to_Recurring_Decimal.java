/**

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"

**/

public String fractionToDecimal(int numerator, int denominator) {
	if(numerator == 0) {
		return "0";
	}
	StringBuilder res = new StringBuilder();
	int sign = ((numerator > 0) ^ (denominator > 0))? -1 : 1;
	long n = Math.abs((long)numerator);
	long m = Math.abs((long)denominator);
	if(sign < 0) {
		res.append("-");
	}
	res.append(n / m);
	long left = n % m;
	if(left == 0) {
		return res.toString();
	}
	res.append('.');
	Map<Long, Integer> map = new HashMap<>();
	while(left != 0) {
		map.put(left, res.length());
		long cur = (left * 10) / m;
		left = (left * 10) % m;
		res.append(cur);
		if(map.containsKey(left)) {
			res.insert(map.get(left), "(");
			res.append(')');
			return res.toString();
		}
	}
	return res.toString();
}









