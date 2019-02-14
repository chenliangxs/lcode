/**
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
Therefore, return the median sliding window as [1,-1,-1,3,5,6].

Note:
You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
**/

public double[] medianSlidingWindow(int[] nums, int k) {
    int n = nums.length;
    double[] res = new double[n - k + 1];
    if(k == 0) {
        return res;
    }
    PriorityQueue<Long> leftMax = new PriorityQueue<>(new Comparator<Long>(){
        public int compare(Long i, Long j) {
            if(i < j) {
                return 1;
            } else if(i > j) {
                return -1;
            } else {
                return 0;
            }
        }
    });
    PriorityQueue<Long> rightMin = new PriorityQueue<>(new Comparator<Long>(){
        public int compare(Long i, Long j) {
            if(i < j) {
                return -1;
            } else if(i > j) {
                return 1;
            } else {
                return 0;
            }
        }
    });

    for(int i = 0; i < nums.length; i++) {
        if(i < k - 1) {
            addTo(nums[i], leftMax, rightMin);
        } else {
            if(i >= k) {
                remove(nums[i - k], leftMax, rightMin);
            }
            addTo(nums[i], leftMax, rightMin);
            if(k % 2 == 0) {
                res[i - k + 1] = (leftMax.peek() + rightMin.peek()) / 2.0;
            } else {
                res[i - k + 1] = leftMax.size() > rightMin.size() ? leftMax.peek() * 1.0 : rightMin.peek() * 1.0;
            }
        }
    }
    return res;
}
public void addTo(int target, PriorityQueue<Long> leftMax, PriorityQueue<Long> rightMin) {
    if(leftMax.isEmpty() && rightMin.isEmpty()) {
        leftMax.offer((long)target);
    } else if (leftMax.isEmpty()) {
        rightMin.offer((long)target);
    } else if(rightMin.isEmpty()) {
        leftMax.offer((long)target);
    } else if(leftMax.peek() >= target) {
        leftMax.offer((long)target);
    } else {
        rightMin.offer((long)target);
    }
    balance(leftMax, rightMin);
    return;
}
public void remove(int target, PriorityQueue<Long> leftMax, PriorityQueue<Long> rightMin) {
    if(!leftMax.isEmpty() && leftMax.peek() >= target) {
        leftMax.remove((long)target);
    } else {
        rightMin.remove((long)target);
    }
    balance(leftMax, rightMin);
}
public void balance(PriorityQueue<Long> leftMax, PriorityQueue<Long> rightMin) {
    if(Math.abs(leftMax.size() - rightMin.size()) < 2) {
        return;
    }
    while(leftMax.size() - rightMin.size() > 1) {
        rightMin.offer(leftMax.poll());
    }
    while(rightMin.size() - leftMax.size() > 1) {
        leftMax.offer(rightMin.poll());
    }
    return;
}
