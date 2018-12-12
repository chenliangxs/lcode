/**
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.

**/


public String multiply(String num1, String num2){
	if(num1.length() == 0 || num2.length() == 0){
		return "";
	}
	int m = num1.length();
	int n = num2.length();
	int[] res = new int[m + n];
	char[] chm = num1.toCharArray();
	char[] chn = num2.toCharArray();
	for(int j = n - 1; j >= 0; j--){
		for(int i = m - 1; i >= 0; i--){
			res[i + j + 1] += (chm[i] - '0') * (chn[j] - '0');
		}
	}
	int carry = 0;
	for(int i = m + n - 1; i >= 0; i--){
		int tmp = res[i];
		res[i] = (res[i] + carry) % 10;
		carry = (tmp + carry) / 10;
	}
	StringBuilder sb = new StringBuilder();
	int index = 0;
	while(index < res.length-1 && res[index] == 0){
		index++;
	}
	while(index < res.length){
		sb.append(res[index++]);
	}
	return sb.toString();
}
