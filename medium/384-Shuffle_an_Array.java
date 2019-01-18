/**
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
**/

class Solution {

    int[] origin;
    int[] output;
    Random r;

    public Solution(int[] nums) {
        origin = Arrays.copyOfRange(nums, 0, nums.length);
        output = Arrays.copyOfRange(nums, 0, nums.length);
        r = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        output = Arrays.copyOfRange(origin, 0, origin.length);
        return output;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < output.length; i++) {
            int j = r.nextInt(i + 1);
            int tmp = output[i];
            output[i] = output[j];
            output[j] = tmp;
        }
        return output;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
