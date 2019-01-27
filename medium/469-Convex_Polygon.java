/**
Given a list of points that form a polygon when joined sequentially, find if this polygon is convex (Convex polygon definition).



Note:

There are at least 3 and at most 10,000 points.
Coordinates are in the range -10,000 to 10,000.
You may assume the polygon formed by given points is always a simple polygon (Simple polygon definition). In other words, we ensure that exactly two edges intersect at each vertex, and that edges otherwise don't intersect each other.


Example 1:

[[0,0],[0,1],[1,1],[1,0]]

Answer: True

Explanation:
Example 2:

[[0,0],[0,10],[10,10],[10,0],[5,5]]

Answer: False

Explanation:
**/

public boolean isConvex(List<List<Integer>> points) {
    if(points.size() < 3) {
        return false;
    }
    boolean flag = false;
    int v = 1;
    for(int i = 0; i < points.size(); i++) {
        List<Integer> pointOne = (i == 0 ? points.get(points.size() - 1) : points.get(i - 1));
        List<Integer> pointTwo = points.get(i);
        List<Integer> pointThree = (i < points.size() - 1 ? points.get(i + 1) : points.get(0));
        int tmp = (pointTwo.get(0) - pointOne.get(0)) * (pointThree.get(1) - pointOne.get(1))
            - (pointTwo.get(1) - pointOne.get(1)) * (pointThree.get(0) - pointOne.get(0));
        if(!flag) {
            if(tmp > 0) {
                flag = true;
            } else if(tmp < 0) {
                v = -1;
                flag = true;
            }
        } else {
            if(v * tmp < 0) {
                return false;
            }
        }
    }
    return true;
}
