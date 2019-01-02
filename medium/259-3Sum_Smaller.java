/**
Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Example:

Input: nums = [-2,0,1,3], and target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
             [-2,0,1]
             [-2,0,3]
Follow up: Could you solve it in O(n2) runtime?
**/

public int threeSumSmaller(int[] nums, int target) {
    List<int[]> tmp = new ArrayList<>();
    for(int i = 0; i < nums.length - 2; i++) {
        for(int j = i + 1; j < nums.length - 1; j++) {
            int[] comb = new int[]{i, j, nums[i] + nums[j]};
            tmp.add(comb);
        }
    }
    int count = 0;
    for(int i = 0; i < tmp.size(); i++) {
        int second = tmp.get(i)[1];
        for(int k = second + 1; k < nums.length; k++) {
            if(tmp.get(i)[2] + nums[k] < target) {
                count++;
            }
        }
    }
    return count;
}
