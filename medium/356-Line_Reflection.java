/**
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.

Example 1:

Input: [[1,1],[-1,1]]
Output: true
Example 2:

Input: [[1,1],[-1,-1]]
Output: false
Follow up:
Could you do better than O(n2) ?
**/

public boolean isReflected(int[][] points) {
    if(points.length == 0) {
        return true;
    }
    Arrays.sort(points, new Comparator<int[]>(){
        public int compare(int[] i1, int[] i2) {
            return i1[0] - i2[0];
        }
    });
    double target = (points[0][0] + points[points.length - 1][0]) / 2.0;
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for(int[] point : points) {
        int x = point[0];
        int y = point[1];
        if(!map.containsKey(x)) {
            map.put(x, new HashSet<Integer>());
        }
        map.get(x).add(y);
    }
    for(int i = 0; i < (points.length + 1) / 2; i++) {
        int[] point = points[i];
        int x = point[0];
        int y = point[1];
        int targetX = (int)(2 * target) - x;
        if(!map.containsKey(targetX) || !map.get(targetX).contains(y)) {
            return false;
        }
    }
    return true;
}
