/**
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

**/

public List<String> findMissingRanges(int[] nums, int lower, int upper) {
    List<String> res = new ArrayList<>();
    /**
    if(nums.length == 0) {
        String tmp = (lower == upper) ? ""+lower : lower + "->" + upper;
        res.add(tmp);
        return res;
    }
    **/
    long end = (long)lower - 1;
    for(int i = 0; i < nums.length; i++) {
        if(end + 1 >= nums[i]) {
            end = (long)nums[i];
        } else {
            if(nums[i] - 1 == end + 1) {
                String tmp = (end + 1) + "";
                res.add(tmp);
            } else {
                String tmp = (end + 1) + "->" + (nums[i] - 1);
                res.add(tmp);
            }
            end = (long)nums[i];
        }
    }
    if(end >= upper) {
        return res;
    } else {
        String tmp = (upper - end == 1) ? upper + "" : (end + 1) + "->" + upper;
        res.add(tmp);
        return res;
    }
}
