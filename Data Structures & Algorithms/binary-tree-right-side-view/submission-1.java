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

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // BFS solution. Little bit more code, but intuitive
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode rightestNode = null;
            for(int i=0;i<size;i++) {
                rightestNode = q.poll();
                if(rightestNode.left != null) {
                    q.add(rightestNode.left);
                }
                if(rightestNode.right != null) {
                    q.add(rightestNode.right);
                }
            }
            if(rightestNode != null)
                res.add(rightestNode.val);
        }
        return res;
    }
}
