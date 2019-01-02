/**
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
*/

public List<Integer> diffWaysToCompute(String input) {
    List<Integer> res = new ArrayList<>();
    if(input.length() == 0) {
        return res;
    }
    if(input.indexOf("+") == -1  && input.indexOf("-") == -1 && input.indexOf("*") == -1) {
        res.add(Integer.parseInt(input));
        return res;
    }
    for(int i = 0; i < input.length(); i++) {
        if(input.charAt(i) == '+') {
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for(int l : left) {
                for(int r : right) {
                    int tmp = l + r;
                    res.add(tmp);
                }
            }
        } else if(input.charAt(i) == '-') {
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for(int l : left) {
                for(int r : right) {
                    int tmp = l - r;
                    res.add(tmp);
                }
            }
        } else if(input.charAt(i) == '*') {
            List<Integer> left = diffWaysToCompute(input.substring(0, i));
            List<Integer> right = diffWaysToCompute(input.substring(i + 1));
            for(int l : left) {
                for(int r : right) {
                    int tmp = l * r;
                    res.add(tmp);
                }
            }
        }
    }
    return res;
}
