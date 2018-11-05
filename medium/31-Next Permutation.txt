Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1

===================================

public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        int target = nums.length - 2;
        while(target >=0 && nums[target] >= nums[target + 1]){
            target--;
        }
        if(target >= 0){
            int next = nums.length - 1;
            while(next >=0 && nums[next] <= nums[target]){
                next--;
            }
            swap(nums, target, next);
        }
        reverse(nums, target + 1, nums.length - 1);
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }