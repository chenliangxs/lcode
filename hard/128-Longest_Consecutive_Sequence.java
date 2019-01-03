/**
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
========================================================
**/
public int longestConsecutive(int[] nums) {
    Map<Integer, Range> map = new HashMap<>();
    for(int x:nums){
        if(map.containsKey(x)) continue;
        int leftBoundary = x;
        int rightBoundary = x;
        if(map.containsKey(x+1)){
            rightBoundary = Math.max(map.get(x+1).right, x+1);
        }
        if(map.containsKey(x-1)){
            leftBoundary = Math.min(map.get(x-1).left, x-1);
        }
        Range cur = new Range(leftBoundary, rightBoundary);
        map.put(x, cur);
        if(map.containsKey(leftBoundary)){
            map.get(leftBoundary).right = map.get(x).right;
        }
        if(map.containsKey(rightBoundary)){
            map.get(rightBoundary).left = map.get(x).left;
        }
    }
    int res = 0;
    for(int k:map.keySet()){
        res = Math.max(map.get(k).right - map.get(k).left + 1, res);
    }
    return res;
}
class Range{
    int left;
    int right;
    public Range(int left, int right){
        this.left = left;
        this.right = right;
    }
}
