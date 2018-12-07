There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.

=======================================================

public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;
        if(ratings.length == 1) return 1;
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        for(int i=1; i<ratings.length; i++){
            if(ratings[i] > ratings[i-1]){
                left[i] = left[i-1] + 1;
            }
        }
        for(int j=ratings.length - 2; j>=0; j--){
            if(ratings[j] > ratings[j+1]){
                right[j] = right[j+1] + 1;
            }
        }
        int total = ratings.length;
        for(int i=0; i<ratings.length; i++){
            total += Math.max(left[i], right[i]);
        }
        return total;
    }