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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            hmap.put(inorder[i], i);
        }

        TreeNode root = buildSubTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, hmap);

        return root;
    }

    public TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> hmap) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = hmap.get(preorder[preStart]);
        int diff = inRoot - inStart;

        root.left = buildSubTree(preorder, preStart + 1, preStart + diff, inorder, inStart, inRoot - 1, hmap);

        root.right = buildSubTree(preorder, preStart + diff + 1, preEnd, inorder, inRoot + 1, inEnd, hmap);

        return root;
    }
}