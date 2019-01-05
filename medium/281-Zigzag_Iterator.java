/**
Given two 1d vectors, implement an iterator to return their elements alternately.

Example:

Input:
v1 = [1,2]
v2 = [3,4,5,6] 

Output: [1,3,2,4,5,6]

Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,3,2,4,5,6].
Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

Clarification for the follow up question:
The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:

Input:
[1,2,3]
[4,5,6,7]
[8,9]

Output: [1,4,8,2,5,9,3,6,7].
**/

public class ZigzagIterator {
	Queue<int[]> que;
	List<List<Integer>> container;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	container = new ArrayList<List<Integer>>();
	que = new LinkedList<>();
	if(v1.size() > 0) {
		int[] first = new int[]{container.size(), 0};
		que.offer(first);
		container.add(v1);
	}
	if(v2.size() > 0) {
		int[] second = new int[]{container.size(), 0};
		que.offer(second);
		container.add(v2);
	}
    }

    public int next() {
        int[] tmp = que.poll();
	int res = container.get(tmp[0]).get(tmp[1]);
	if(container.get(tmp[0]).size() > tmp[1] + 1) {
		int[] next = new int[]{tmp[0], tmp[1] + 1};
		que.offer(next);
	}
	return res;
    }

    public boolean hasNext() {
        return !que.isEmpty();
    }
}














