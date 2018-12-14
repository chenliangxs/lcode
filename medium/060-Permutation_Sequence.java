/**

The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

**/

public String getPermutation(int n, int k){
	List<Integer> candidates = new ArrayList<>();
	for(int i = 1; i <= n; i++){
		candidates.add(i);
	}
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < n; i++){
		int lvl = factorial(n - 1 - i);
		int index = (k - 1) / lvl;
		sb.append(candidates.get(index));
		candidates.remove(index);
		k = (k - 1) % lvl + 1;
	}
	return sb.toString();
}
public int factorial(int n){
	if(n == 0 || n == 1){
		return 1;
	}
	return n * factorial(n - 1);
}































