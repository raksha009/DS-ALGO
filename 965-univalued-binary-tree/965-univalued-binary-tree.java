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
    int gval = 0;
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        
        gval = root.val; // Needed value for Tree to be univalued
        return helper(root);
    }
    
    public boolean helper(TreeNode root){
        if (root == null) return true;
        
        if (root.val != gval) return false;
        boolean lans = helper(root.left);
        boolean rans = helper(root.right);
        
        return (lans && rans);
    }
}