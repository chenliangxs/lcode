/**
Given the head of a graph, return a deep copy (clone) of the graph. Each node in the graph contains a label (int) and a list (List[UndirectedGraphNode]) of its neighbors. There is an edge between the given node and each of the nodes in its neighbors.


OJ's undirected graph serialization (so you can understand error output):
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.


As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.


Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
Note: The i
class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

**/
public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if(node == null) {
        return null;
    }
    Queue<UndirectedGraphNode> q = new LinkedList<>();
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    UndirectedGraphNode root = new UndirectedGraphNode(node.label);
    map.put(node, root);
    q.offer(node);
    Set<UndirectedGraphNode> visited = new HashSet<>();
    visited.add(node);
    while(!q.isEmpty()) {
        UndirectedGraphNode cur = q.poll();
        if(!map.containsKey(cur)) {
            map.put(cur, new UndirectedGraphNode(cur.label));
        }
        for(UndirectedGraphNode child : cur.neighbors) {
            if(!map.containsKey(child)) {
                map.put(child, new UndirectedGraphNode(child.label));
            }
            map.get(cur).neighbors.add(map.get(child));
            if(!visited.contains(child)) {
                q.offer(child);
                visited.add(child);
            }
        }
    }
    return map.get(node);
}
