Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

===========================================

public List<String> letterCombinations(String digits) {
        String[] map = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if(digits.length() == 0) return res;
        StringBuilder path = new StringBuilder();
        dfs(0,digits,path, map, res);
        return res;
    }
    public void dfs(int index, String digits, StringBuilder path, String[] map, List<String> res){
        if(index >= digits.length()){
            res.add(path.toString());
            return;
        }
        String candidates = map[digits.charAt(index) - '1'];
        for(int i = 0; i < candidates.length(); i++){
            path.append(candidates.charAt(i));
            dfs(index + 1, digits, path, map, res);
            path.deleteCharAt(path.length() - 1);
        }
        return;
    }