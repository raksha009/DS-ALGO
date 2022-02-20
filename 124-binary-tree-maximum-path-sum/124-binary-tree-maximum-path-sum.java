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
    
    int maxsum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        maxpathsumhelper(root);
        return maxsum;
    }
    
    // Return max branchsum (i.e. MAX OF (node.val, node.val+leftsum, node.val+rightsum))
    public int maxpathsumhelper(TreeNode root){
        if (root == null) return 0;
        
        int leftans = maxpathsumhelper(root.left);
        int rightans = maxpathsumhelper(root.right);
        
        // Updating maxsum
        maxsum = Math.max(maxsum, Math.max(root.val, Math.max(root.val + leftans, Math.max(root.val + rightans, root.val+leftans+rightans))));
        
        
        return Math.max(root.val, Math.max(root.val + leftans, root.val + rightans));
    }
}