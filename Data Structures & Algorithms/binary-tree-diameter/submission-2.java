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
    // Not really EASY, definitely a MEDIUM, since in dfs(), the return value
    // is not really the diameter, but the height
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        dfs(root, maxDiameter);
        return maxDiameter[0];
    }

    private int dfs(TreeNode root, int[] maxDiameter) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, maxDiameter);
        int right = dfs(root.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], left + right);
        return 1 + Math.max(left, right);
    }
}