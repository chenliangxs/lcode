/**
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

**/

public int singleNumber(int[] nums) {
    int res = 0;
    for(int i = 31; i >= 0; i--) {
        int mask = (1 << i);
        int count = 0;
        for(int n : nums) {
            if((n & mask) != 0) {
                count++;
            }
        }
        if(count % 3 == 1) {
            res |= mask;
        }
    }
    return res;
}
