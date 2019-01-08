/**
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
**/

class NumArray {

    class Seg {
        int start;
        int end;
        int sum;
        Seg left;
        Seg right;
        public Seg(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            left = null;
            right = null;
        }
    }

    Seg root;
    int size;

    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
        size = nums.length;
    }
    public Seg build(int[] nums, int i, int j) {
        if(i > j) {
            return null;
        }
        if(i == j) {
            return new Seg(i, j, nums[i]);
        }
        int mid = (i + j) / 2;
        Seg l = build(nums, i, mid);
        Seg r = build(nums, mid + 1, j);
        Seg root = new Seg(i, j, l.sum + r.sum);
        root.left = l;
        root.right = r;
        return root;
    }

    public void update(int i, int val) {
        if(i < 0 || i >= size) {
            return;
        }
        update(root, i, val);
    }
    public int update(Seg root, int index, int val) {
        if(root == null) {
            return 0;
        }
        if(root.start == index && root.end == index) {
            int diff = val - root.sum;
            root.sum = val;
            return diff;
        }
        int l = root.start;
        int r = root.end;
        int mid = (l + r) / 2;
        if(index >= l && index <= mid) {
            int diffLeft = update(root.left, index, val);
            root.sum += diffLeft;
            return diffLeft;
        } else if(index > mid && index <= r) {
            int diffRight = update(root.right, index, val);
            root.sum += diffRight;
            return diffRight;
        }
        return 0;
    }

    public int sumRange(int i, int j) {
        if(i < 0) {
            return sumRange(0, j);
        }
        if(j >= size) {
            return sumRange(i, size - 1);
        }
        if(i > j) {
            return 0;
        }
        return getSum(root, i, j);
    }
    public int getSum(Seg root, int i, int j) {
        if(i > j) {
            return 0;
        }
        if(root.start == i && root.end == j) {
            return root.sum;
        }
        int mid = (root.start + root.end) / 2;
        if(i <= mid && j <= mid) {
            return getSum(root.left, i, j);
        } else if(i > mid && j > mid) {
            return getSum(root.right, i, j);
        } else {
            return getSum(root.left, i, mid) + getSum(root.right, mid + 1, j);
        }
    }
}
