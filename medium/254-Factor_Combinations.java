/**
Numbers can be regarded as product of its factors. For example,

8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.

Note:

You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Example 1:

Input: 1
Output: []
Example 2:

Input: 37
Output:[]
Example 3:

Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
Example 4:

Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
**/

public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(n, path, res);
    return res;
}
public void dfs(int n, List<Integer> path, List<List<Integer>> res) {
    for(int i = 2; i < n; i++) {
        if(n % i == 0) {
            path.add(i);
            path.add(n / i);
            List<Integer> tmp = new ArrayList<Integer>(path);
            Collections.sort(tmp);
            String list = "";
            for(int t : tmp) {
                list = list + t;
            }
            if(!added.contains(list)) {
                res.add(tmp);
                added.add(list);
            }
            path.remove(path.size() - 1);
            dfs(n / i, path, res, added);
            path.remove(path.size() - 1);
        }
    }
}

//sol 2
public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(n, 2, path, res);
    return res;
}
public void dfs(int n, int start, List<Integer> path, List<List<Integer>> res) {
    if(n <= 1) {
        return;
    }
    for(int i = start; i * i <= n; i++) {
        if(n % i == 0) {
            path.add(i);
            path.add(n / i);
            res.add(new ArrayList<Integer>(path));
            path.remove(path.size() - 1);
            dfs(n / i, i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
//sol3
public List<List<Integer>> getFactors(int n) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    dfs(n, 2, path, res);
    return res;
}
public void dfs(int n, int start, List<Integer> path, List<List<Integer>> res) {
    if(n <= 1) {
        if(path.size() > 1) {
            res.add(new ArrayList<Integer>(path));
        }
        return;
    }
    for(int i = start; i <= n; i++) {
        if(n % i == 0) {
            path.add(i);
            dfs(n / i, i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
