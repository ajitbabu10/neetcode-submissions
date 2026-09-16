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

    // OWN SOLUTION
    int res=0;
    public int goodNodes(TreeNode root) {
        int min = Integer.MIN_VALUE;
        dfs(root, min);
        return res;
    }

    public void dfs(TreeNode root, int max) {
        if(root == null) 
            return;

        if(root.val >= max) {
            res++;
        }
        max = Math.max(max, root.val);

        dfs(root.left, max);
        dfs(root.right, max);
    }
}
