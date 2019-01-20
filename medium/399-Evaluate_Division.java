/**
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
**/
public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    Map<String, Map<String, Double>> map = new HashMap<>();
    for(int i = 0; i < equations.length; i++) {
        String[] equation = equations[i];
        String a = equation[0];
        String b = equation[1];
        if(!map.containsKey(a)) {
            map.put(a, new HashMap<String, Double>());
        }
        map.get(a).put(b, values[i]);

        if(!map.containsKey(b)) {
            map.put(b, new HashMap<String, Double>());
        }
        map.get(b).put(a, 1 / values[i]);
    }
    double[] res = new double[queries.length];
    for(int i = 0; i < queries.length; i++) {
        String start = queries[i][0];
        String end = queries[i][1];
        Set<String> visited = new HashSet<>();
        visited.add(start);
        res[i] = dfs(start, end, map, visited);
    }
    return res;
}
public double dfs(String start, String end, Map<String, Map<String, Double>> map, Set<String> visited) {
    if(!map.containsKey(start)) {
        return -1.0;
    }
    if(start.equals(end)) {
        return 1.0;
    }
    double res = -1.0;
    Map<String, Double> next = map.get(start);
    for(String follow : next.keySet()) {
        if(!visited.contains(follow)) {
            visited.add(follow);
            double v = dfs(follow, end, map, visited);
            if(v != -1.0) {
                res = next.get(follow) * v;
                break;
            }
            visited.remove(follow);
        }
    }
    if(res == -1.0) {
        return res;
    }
    map.get(start).put(end, res);
    if(!map.containsKey(end)) {
        map.put(end, new HashMap<String, Double>());
    }
    map.get(end).put(start, 1 / res);
    return res;
}
