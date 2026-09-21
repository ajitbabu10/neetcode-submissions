/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    int i;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsSerialize(root, res);
        return String.join(",", res); 
    }

    public void dfsSerialize(TreeNode root, List<String> res) {
        if(root == null) {
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsSerialize(root.left, res);
        dfsSerialize(root.right, res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        TreeNode root = dfsDeserialize(vals);
        i=0;
        return root;
    }

    public TreeNode dfsDeserialize(String[] vals) {
        if(vals[i].equals("N")) {
            i++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(vals[i]));
        i++;
        root.left = dfsDeserialize(vals);
        root.right = dfsDeserialize(vals);
        return root;
    }
}
