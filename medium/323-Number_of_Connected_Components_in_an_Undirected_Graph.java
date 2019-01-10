/**
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:

Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]

     0          3
     |          |
     1 --- 2    4 

Output: 2
Example 2:

Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3

Output:  1
Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.


**/

public int countComponents(int n, int[][] edges) {
	int[] parent = new int[n];
	for(int i = 0; i < n; i++) {
		parent[i] = i;
	}
	for(int[] edge : edges) {
		int r1 = findRoot(edge[0], parent);
		int r2 = findRoot(edge[1], parent);
		if(r1 != r2) {
			parent[r1] = r2;
		}	
		parent[edge[0]] = r2;
		parent[edge[1]] = r2;
	}
	int count = 0;
	for(int i = 0; i < n; i++) {
		if(parent[i] == i) {
			count++;
		}
	}
	return count;
}
public int findRoot(int x, int[] parent) {
	while(x != parent[x]) {
		x = parent[x];
	}
	return x;
}




















