/**
Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

Input: [3, 10, 5, 25, 2, 8]

Output: 28

Explanation: The maximum result is 5 ^ 25 = 28.
**/

public int findMaximumXOR(int[] nums) {
	int res = 0;
	int mask = 0;
	for(int i = 31; i >= 0 ; i--) {
		mask |= (1 << i);
		Set<Integer> set = new HashSet<>();
		int goal = res | (1 << i);
		for(int n : nums) {
			set.add((mask & n));
			if(set.contains(goal ^ (mask & n))) {
				res |= goal;
				break;
			}
		}
	}
	return res;
}
