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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) {
            return true;
        } 
        if(root == null) {
            return false;
        }
        if(isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot);
    }

    // Another Separate Tree Problem
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // true condition
        boolean check = true;
        if(p == null && q == null) return true;


        // false conditions
        if( (p == null && q != null) ||
            (p != null && q == null) ||
            (p.val != q.val)) {
                return false;
            }

        check = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return check;    
    }
}
