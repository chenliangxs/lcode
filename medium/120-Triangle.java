/**

Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

**/

public int minimumTotal(List<List<Integer>> triangle) {
    int m = triangle.size();
    int n = triangle.get(m - 1).size();
    int[] sum = new int[n];
    for(int i = m - 1; i >= 0 ; i--) {
        if(i == m - 1) {
            for(int j = 0; j < n; j++) {
                sum[j] = triangle.get(i).get(j);
            }
        } else {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                sum[j] = triangle.get(i).get(j) + Math.min(sum[j], sum[j + 1]);
            }
        }
    }
    return sum[0];
}
