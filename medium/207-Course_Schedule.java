/**
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
Note:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.

**/

public boolean canFinish(int numCourses, int[][] prerequisites) {
    int[] pre = new int[numCourses];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for(int[] pair : prerequisites) {
        int c = pair[0];
        int p = pair[1];
        pre[c]++;
        if(!map.containsKey(p)) {
            map.put(p, new HashSet<Integer>());
        }
        map.get(p).add(c);
    }
    Queue<Integer> que = new LinkedList<>();
    for(int i = 0; i < numCourses; i++) {
        if(pre[i] == 0) {
            que.offer(i);
        }
    }
    while(!que.isEmpty()) {
        int cur = que.poll();
        Set<Integer> follow = map.containsKey(cur) ? map.get(cur) : new HashSet<Integer>();
        for(int f : follow) {
            pre[f]--;
            if(pre[f] == 0) {
                que.offer(f);
            }
        }
    }
    for(int i = 0; i < pre.length; i++) {
        if(pre[i] > 0) {
            return false;
        }
    }
    return true;
}
