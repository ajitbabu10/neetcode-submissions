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
    public int kthSmallest(TreeNode root, int k) {
        // Morris traversal - Striver video
        int count = 0;
        TreeNode curr = root;
        while(curr != null) {
            // no left subtree
            if(curr.left == null) {
                count++;
                if(count == k) {
                    return curr.val;
                }
                curr = curr.right;
            }
            // has left subtree
            else {
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) {
                    // go to right most
                    pred = pred.right;
                }

                // two failing cases in above while loop
                // 1st case - we havent visited this node
                if(pred.right == null) {
                    pred.right = curr; //make thread link
                    curr = curr.left;
                } 
                // 2nd case - we already met(pred.right == curr)
                else {
                    // break thread link
                    pred.right = null;
                    count++;
                    if(count == k) {
                        return curr.val;
                    }
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
