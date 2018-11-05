Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
===================================================

public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int max = nums[0];
        int min = nums[0];
        for(int i=1; i< nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if(max == min) return 0;
        int step = (max - min)/nums.length + 1;
        int size = (max - min)/step + 1;
        int[][] buckets = new int[size][2];
        
        for(int x:nums){
            int index = (x - min) / step;
            int[] border = buckets[index];
            if(border[0] == 0 || x < border[0]){
                buckets[index][0] = x;
            }
            if(border[1] == 0 || x > border[1]){
                buckets[index][1] = x;
            }
        }
        int maxGap = 0;
        int end = buckets[0][1];
        for(int i=1; i<buckets.length; i++){
            if(buckets[i][0] == 0) continue;
            maxGap = Math.max(maxGap, buckets[i][0] - end);
            end = buckets[i][1];
        }
        return maxGap;
    }