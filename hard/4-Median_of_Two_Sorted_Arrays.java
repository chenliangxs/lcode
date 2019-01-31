
/**
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
**/

public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    if((m + n) % 2 == 0) {
        int first = findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2);
        int second = findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1);
        return (first + second) / 2.0;
    } else {
        return findKth(nums1, 0, m - 1, nums2, 0, n - 1, (m + n) / 2 + 1) * 1.0;
    }
}
public int findKth(int[] nums1, int leftOne, int rightOne, int[] nums2, int leftTwo, int rightTwo, int k) {
    if(rightOne - leftOne > rightTwo - leftTwo) {
        return findKth(nums2, leftTwo, rightTwo, nums1, leftOne, rightOne, k);
    }
    if(rightOne < leftOne) {
        return nums2[leftTwo + k - 1];
    }
    if(k == 1) {
        return Math.min(nums1[leftOne], nums2[leftTwo]);
    }

    int countOne = (rightOne - leftOne + 1 > k / 2) ? k / 2 : rightOne - leftOne + 1;
    int countTwo = k - countOne;

    if(nums1[leftOne + countOne - 1] < nums2[leftTwo + countTwo - 1]) {
        return findKth(nums1, leftOne + countOne, rightOne, nums2, leftTwo, rightTwo, k - countOne);
    } else {
        return findKth(nums1, leftOne, rightOne, nums2, leftTwo + countTwo, rightTwo, countOne);
    }
}
