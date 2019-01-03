/**
Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.

Note: You should try to optimize your time and space complexity.

Example 1:

Input:
nums1 = [3, 4, 6, 5]
nums2 = [9, 1, 2, 5, 8, 3]
k = 5
Output:
[9, 8, 6, 5, 3]
Example 2:

Input:
nums1 = [6, 7]
nums2 = [6, 0, 4]
k = 5
Output:
[6, 7, 6, 0, 4]
Example 3:

Input:
nums1 = [3, 9]
nums2 = [8, 9]
k = 3
Output:
[9, 8, 9]
**/

public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        for(int i = 0; i <= Math.min(m, k); i++){
            int[] A = pick(nums1, i);
            int[] B = pick(nums2, Math.min(k - i, n));
            if(A.length + B.length == k){
                int[] tmp = merge(A, B);
                if(check(tmp, 0, res, 0)){
                    res = tmp;
                }
            }
        }
        return res;
    }
    public int[] pick(int[] nums, int k){
        int[] res = new int[k];
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            while(nums.length - i + index > k && index > 0 && nums[i] > res[index - 1]){
                index--;
            }
            if(index >= 0 && index < k){
                res[index++] = nums[i];
            }
        }
        return res;
    }
    public int[] merge(int[] A, int[] B){
        int m = A.length;
        int n = B.length;
        int[] res = new int[m + n];
        int index = 0;
        int i = 0;
        int j = 0;
        while(index < m + n){
            if(i < m && j < n){
                if(check(A, i, B, j)){
                    res[index++] = A[i++];
                }else{
                    res[index++] = B[j++];
                }
            }else if(i < m){
                res[index++] = A[i++];
            }else{
                res[index++] = B[j++];
            }
        }
        return res;
    }
    public boolean check(int[] A, int x, int[] B, int y){
        while(x < A.length && y < B.length && A[x] == B[y]){
            x++;
            y++;
        }
        return y == B.length || (x < A.length && A[x] > B[y]);
    }
