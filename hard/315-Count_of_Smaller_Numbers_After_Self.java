/**
You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.
**/

public List<Integer> countSmaller(int[] nums) {
    List<Integer> res = new ArrayList<>();
    if(nums.length == 0) {
        return res;
    }
    int[] index = new int[nums.length];
    int[] count = new int[nums.length];
    for(int i = 0; i < nums.length; i++) {
        index[i] = i;
    }
    mergeSort(nums, index, count, 0, nums.length - 1);
    for(int i = 0; i < nums.length; i++) {
        res.add(count[i]);
    }
    return res;
}
public void mergeSort(int[] nums, int[] index, int[] count, int left, int right) {
    if(left == right) {
        return;
    }
    int mid = (left + right) / 2;
    mergeSort(nums, index, count, left, mid);
    mergeSort(nums, index, count, mid + 1, right);
    int[] tmp = new int[right - left + 1];
    int cur = 0;
    int i = left;
    int j = mid + 1;
    while(i <= mid) {
        while(j <= right && nums[index[i]] > nums[index[j]]) {
            tmp[cur++] = index[j++];
        }
        count[index[i]] += j - mid - 1;
        tmp[cur++] = index[i];
        i++;
    }
    while(j <= right) {
        tmp[cur++] = index[j++];
    }
    for(int x = left; x <= right; x++) {
        index[x] = tmp[x - left];
    }
}
