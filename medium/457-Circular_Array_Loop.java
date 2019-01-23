/**
You are given an array of positive and negative integers. If a number n at an index is positive, then move forward n steps. Conversely, if it's negative (-n), move backward n steps. Assume the first element of the array is forward next to the last element, and the last element is backward next to the first element. Determine if there is a loop in this array. A loop starts and ends at a particular index with more than 1 element along the loop. The loop must be "forward" or "backward'.

Example 1: Given the array [2, -1, 1, 2, 2], there is a loop, from index 0 -> 2 -> 3 -> 0.

Example 2: Given the array [-1, 2], there is no loop.

Note: The given array is guaranteed to contain no element "0".

Can you do it in O(n) time complexity and O(1) space complexity?
**/
public boolean circularArrayLoop(int[] nums) {
    int n = nums.length;
    boolean[] visited = new boolean[n];
    for(int i = 0; i < nums.length; i++) {
        if(visited[i]) {
            continue;
        }
        int start = i;
        while(!visited[start]) {
            visited[start] = true;
            int next = (start + nums[start] >= 0) ? (start + nums[start]) % n : start + nums[start] + n;
            if(next == start || nums[next] * nums[start] < 0) {
                break;
            }
            if(next == i) {
                return true;
            }
            start = next;
        }
    }
    return false;
}
