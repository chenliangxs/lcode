/**
Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

Note:

Given target value is a floating point.
You may assume k is always valid, that is: k �� total nodes.
You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
Example:

Input: root = [4,2,5,1,3], target = 3.714286, and k = 2

    4
   / \
  2   5
 / \
1   3

Output: [4,3]

=========================================
**/
public List<Integer> closestKValues(TreeNode root, double target, int k) {
	List<Integer> res = new LinkedList<>();
	if(k == 0 || root == null) return res;
	TreeNode p = root;
	Deque<TreeNode> stack = new ArrayDeque<>();
	while(!stack.isEmpty() || p != null){
		while(p != null){
			stack.offerFirst(p);
			p = p.left;
		}
		TreeNode cur = stack.pollFirst();
		if(res.size() < k){
			res.add(cur.val);
		}else{
			if(Math.abs(cur.val - target) <= Math.abs(res.get(0) - target)){
				res.add(cur.val);
				res.remove(0);
			}else{
				return res;
			}
		}
		p = cur.right;
	}
	return res;
}
