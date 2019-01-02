/**
Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

Example 1:

Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
Output: true
Example 2:

Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
Output: false
Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
**/

public boolean validTree(int n, int[][] edges) {
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for(int[] edge : edges) {
        int p1 = edge[0];
        int p2 = edge[1];
        if(!map.containsKey(p1)) {
            map.put(p1, new HashSet<Integer>());
        }
        map.get(p1).add(p2);
        if(!map.containsKey(p2)) {
            map.put(p2, new HashSet<Integer>());
        }
        map.get(p2).add(p1);
    }
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> que = new LinkedList<>();
    que.offer(0);
    visited.add(0);
    while(!que.isEmpty()) {
        int cur = que.poll();
        Set<Integer> next = map.containsKey(cur) ? new HashSet<Integer>(map.get(cur)) : new HashSet<Integer>();
        for(int i : next) {
            if(visited.contains(i)) {
                return false;
            }
            visited.add(i);
            que.offer(i);
            map.get(i).remove(cur);
            map.get(cur).remove(i);
        }
    }
    return visited.size() == n;
}

//sol2
public boolean validTree(int n, int[][] edges) {
    int[] nodes = new int[n];
    Arrays.fill(nodes, -1);
    for(int[] edge : edges) {
        int x = find(nodes, edge[0]);
        int y = find(nodes, edge[1]);
        if(x == y) {
            return false;
        }
        nodes[x] = y;
    }
    return edges.length == n - 1;
}
public int find(int[] nodes, int index) {
    if(nodes[index] == -1) {
        nodes[index] = index;
        return index;
    }
    while(nodes[index] != index) {
        //nodes[index] = nodes[nodes[index]];
        index = nodes[index];
    }
    return index;
}
