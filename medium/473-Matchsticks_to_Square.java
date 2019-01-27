/**
Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

Example 1:
Input: [1,1,2,2,2]
Output: true

Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:
Input: [3,3,3,3,4]
Output: false

Explanation: You cannot find a way to form a square with all the matchsticks.
Note:
The length sum of the given matchsticks is in the range of 0 to 10^9.
The length of the given matchstick array will not exceed 15.
**/
public boolean makesquare(int[] nums) {
    if(nums.length < 4) {
        return false;
    }
    int sum = 0;
    for(int n : nums) {
        sum += n;
    }
    if(sum % 4 != 0) {
        return false;
    }
    int[] edges = new int[4];
    return dfs(0, nums, edges, sum / 4);
}
public boolean dfs(int index, int[] nums, int[] edges, int target) {
    if(index == nums.length) {
        for(int i = 0; i < edges.length; i++) {
            if(edges[i] != target) {
                return false;
            }
        }
        return true;
    }
    for(int i = 0; i < edges.length; i++) {
        if(nums[index] + edges[i] > target) {
            continue;
        } else {
            edges[i] += nums[index];
            if(dfs(index + 1, nums, edges, target)) {
                return true;
            }
            edges[i] -= nums[index];
        }
    }
    return false;
}
