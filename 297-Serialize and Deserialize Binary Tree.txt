Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

========================================

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp == null){
                sb.append('#');
                sb.append(',');
            }else{
                q.offer(tmp.left);
                q.offer(tmp.right);
                sb.append(tmp.val);
                sb.append(',');
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        if(vals[0].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);
        int index = 1;
        while(q.size() > 0){
            TreeNode tmp = q.poll();
            if(vals[index].equals("#")){
                tmp.left = null;
            }else{
                tmp.left = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(tmp.left);
            }
            index++;
            if(vals[index].equals("#")){
                tmp.right = null;
            }else{
                tmp.right = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(tmp.right);
            }
            index++;
        }
        return root;
    }
}