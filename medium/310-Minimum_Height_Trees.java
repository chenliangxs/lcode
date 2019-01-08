/*8
For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.

Format
The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.

Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3

Output: [1]
Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5

Output: [3, 4]
Note:

According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
**/

public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> res = new ArrayList<>();
    if(n == 1) {
        res.add(0);
        return res;
    }
    Map<Integer, Set<Integer>> map = new HashMap<>();
    int[] income = new int[n];
    for(int[] edge : edges) {
        int a = edge[0];
        int b = edge[1];
        if(!map.containsKey(a)) {
            map.put(a, new HashSet<Integer>());
        }
        map.get(a).add(b);
        if(!map.containsKey(b)) {
            map.put(b, new HashSet<Integer>());
        }
        map.get(b).add(a);
        income[a]++;
        income[b]++;
    }
    Queue<Integer> que = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    for(int i = 0; i < n; i++) {
        if(income[i] == 1) {
            que.offer(i);
            visited.add(i);
            income[i]--;
        }
    }
    int lvlSize = que.size();
    while(n > 2) {
        n -= lvlSize;
        for(int i = 0; i < lvlSize; i++) {
            int cur = que.poll();
            Set<Integer> next = map.get(cur);
            for(int x : next) {
                if(!visited.contains(x)) {
                    income[x]--;
                    if(income[x] == 1) {
                        que.offer(x);
                        visited.add(x);
                    }
                }
            }
        }
        lvlSize = que.size();
    }
    while(!que.isEmpty()) {
        res.add(que.poll());
    }
    return res;
}
