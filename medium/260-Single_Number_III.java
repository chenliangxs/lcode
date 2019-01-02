/**
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]
Note:

The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
**/

public int[] singleNumber(int[] nums) {
    int or = 0;
    for(int i : nums) {
        or ^= i;
    }
    int index = 0;
    for(; index <32; index++) {
        int mask = 1 << index;
        if((mask & or) != 0) {
            break;
        }
    }
    int a = 0;
    for(int i : nums) {
        if((i & (1 << index)) != 0) {
            a ^= i;
        }
    }
    return new int[]{a, (or ^ a)};
}
