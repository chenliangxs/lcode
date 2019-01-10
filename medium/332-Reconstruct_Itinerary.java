/**
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:

Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
Example 2:

Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
             But it is larger in lexical order.
**/

public List<String> findItinerary(String[][] tickets) {
    List<String> res = new ArrayList<>();
    Set<String[]> used = new HashSet<>();
    Arrays.sort(tickets, new Comparator<String[]>(){
        public int compare(String[] s1, String[] s2) {
            if(s1[0].compareTo(s2[0]) == 0) {
                return s1[1].compareTo(s2[1]);
            }
            return s1[0].compareTo(s2[0]);
        }
    });
    res.add("JFK");
    dfs("JFK", res, tickets, used);
    return res;
}
public boolean dfs(String start, List<String> res, String[][] tickets, Set<String[]> used) {
    if(tickets.length == used.size()) {
        return true;
    }
    for(String[] ticket : tickets) {
        if(start.equals(ticket[0]) && !used.contains(ticket)) {
            res.add(ticket[1]);
            used.add(ticket);
            boolean flag = dfs(ticket[1], res, tickets, used);
            if(flag){
                return true;
            }
            used.remove(ticket);
            res.remove(res.size() - 1);
        }
    }
    return false;
}
