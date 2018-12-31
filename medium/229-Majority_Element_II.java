/**
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
**/

public List<Integer> majorityElement(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int first = Integer.MAX_VALUE;
    int second = Integer.MAX_VALUE;
    int countOne = 0;
    int countTwo = 0;
    for(int i = 0; i < nums.length; i++) {
        if(nums[i] == first) {
            countOne++;
        } else if(nums[i] == second) {
            countTwo++;
        } else if(countOne == 0){
            first = nums[i];
            countOne = 1;
        } else if(countTwo == 0) {
            second = nums[i];
            countTwo = 1;
        } else {
            countOne--;
            countTwo--;
        }
    }
    countOne = 0;
    countTwo = 0;
    for(int i : nums) {
        if(i == first) {
            countOne++;
        }else if(i == second) {
            countTwo++;
        }
    }
    if(countOne > nums.length / 3) {
        res.add(first);
    }
    if(countTwo > nums.length / 3) {
        res.add(second);
    }
    return res;
}
