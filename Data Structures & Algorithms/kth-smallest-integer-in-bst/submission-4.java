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
        // Morris traversal practice:
        TreeNode curr = root;
        int count = 0;
        while(curr != null) {
            //no left subtree
            if(curr.left == null) {
                count++;
                if(count == k) {
                    return curr.val;
                }
                curr = curr.right;
            }
            //has left subtree
            else {
                //move to rightest
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                //2 breaking points
                if(pred.right == null) {//no link - > make link 
                    pred.right = curr;
                    curr = curr.left;
                } 
                if(pred.right == curr) {//already visited
                    pred.right = null; //break Link
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
