/**
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
**/


public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder res = new StringBuilder();
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		while(!que.isEmpty()) {
			TreeNode cur = que.poll();
			if(cur == null) {
				res.append("#");
				res.append(",");
			} else {
				res.append(cur.val);
				res.append(",");
				que.offer(cur.left);
				que.offer(cur.right);
			}
		}
		res.deleteCharAt(res.length() - 1);
		return res.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		String[] strs = data.split(",");
		if(strs.length < 2) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
		Queue<TreeNode> que = new LinkedList<>();
		que.offer(root);
		int index = 1;
		while(!que.isEmpty()) {
			TreeNode cur = que.poll();
			if(strs[index].equals("#")) {
				cur.left = null;
			} else {
				cur.left = new TreeNode(Integer.parseInt(strs[index]));
				que.offer(cur.left);
			}
			index++;
			if(strs[index].equals("#")) {
				cur.right = null;
			} else {
				cur.right = new TreeNode(Integer.parseInt(strs[index]));
				que.offer(cur.right);
			}
			index++;
		}
		return root;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
