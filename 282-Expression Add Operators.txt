Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []

=====================================================

public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num.length() == 0) return res;
        StringBuilder path = new StringBuilder();
        long sum = 0;
        long pre = 0;
        dfs(0, pre, sum, target, num, path, res);
        return res;
    }
    public void dfs(int index, long pre, long sum, int target, String num, StringBuilder path, List<String> res){
        if(index == num.length()){
            if(target == sum){
                res.add(path.toString());
            }
            return;
        }
        for(int i=index+1; i<=num.length(); i++){
            if(num.charAt(index) == '0' && i > index + 1) return;
            int len = path.length();
            String st = num.substring(index, i);
            long cur = Long.parseLong(st);
            if(index > 0){
                path.append('+');
                path.append(st);
                dfs(i, cur, sum + cur, target, num, path, res);
                path.setCharAt(len, '-');
                dfs(i, -cur, sum - cur, target, num, path, res);
                path.setCharAt(len, '*');
                dfs(i, pre * cur, sum - pre + pre * cur, target, num, path, res);
                path.setLength(len);
            }else{
                path.append(st);
                dfs(i, cur, sum + cur, target, num, path, res);
                path.setLength(len);
            }
        }
    }

==============================================

public List<String> addOperators(String num, int target){
	List<String> res = new ArrayList<>();
	StringBuilder path = new StringBuilder();
	int index = 0;
	long val = 0;
	long pre = 0;
	dfs(index, num, val, pre, path, res, (long) target);
	return res;
}
public void dfs(int index, String num, long val, long pre, StringBuilder path, List<String> res, long target){
	if(index == num.length() && val == target){
		res.add(path.toString());
		return;
	}
	for(int i = index + 1; i <= num.length(); i++){
		String next = num.substring(index, i);
		if(next.length() > 1 && next.charAt(0) == '0') return;
		else{
			int curLen = path.length();
			long n = Long.parseLong(next);
			if(index == 0){
				path.append(next);
				dfs(i, num, n, n, path, res, target);
				path.setLength(curLen);
			}else{
				//plus
				path.append('+');
				path.append(next);
				dfs(i, num, val + n, n, path, res, target);
				//minus
				path.setCharAt(curLen, '-');
				dfs(i, num, val - n, -1*n, path, res, target);
				//product
				path.setCharAt(curLen, '*');
				dfs(i, num, val - pre + pre * n, pre * n, path, res, target);
				path.setLength(curLen);
			}
		}
	}
}