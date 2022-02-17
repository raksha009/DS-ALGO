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
    public TreeNode pruneTree(TreeNode root) {
        prune(root);
        
        if (root == null) return null;
        
        // [0,null,0,0,0]
        if (root.val == 0 && root.left == null && root.right == null) return null;
        return root;
    }
    
    public int prune(TreeNode root){
        if (root == null) return 0;
        
        // leaf node
        if (root.left == null && root.right == null) return root.val;
        
        int lans = prune(root.left);   // Pruning left subtree if it has 0 nodes only
        if (lans == 0) root.left = null;
        
        int rans = prune(root.right);  // Pruning right subtree if has 0 nodes only
        if (rans == 0) root.right = null;
        
        return root.val + lans + rans;
    }
}