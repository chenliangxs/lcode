/**
Implement an iterator to flatten a 2d vector.

Example:

Input: 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
Output: [1,2,3,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false,
             the order of elements returned by next should be: [1,2,3,4,5,6].
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
**/

public class Vector2D implements Iterator<Integer> {

    Iterator<List<Integer>> row;
    Iterator<Integer> col;
    List<Integer> lvl;

    public Vector2D(List<List<Integer>> vec2d) {
        row = vec2d.iterator();
        lvl = row.hasNext() ? row.next() : new ArrayList<Integer>();
        col = lvl.iterator();
    }

    @Override
    public Integer next() {
        return col.next();
    }

    @Override
    public boolean hasNext() {
        if(col.hasNext()) {
            return true;
        }
        if(!row.hasNext()) {
            return false;
        }
        while(!col.hasNext() && row.hasNext()) {
            lvl = row.next();
            col = lvl.iterator();
        }
        //lvl = row.next();
        //col = lvl.iterator();
        return col.hasNext();
    }
}
