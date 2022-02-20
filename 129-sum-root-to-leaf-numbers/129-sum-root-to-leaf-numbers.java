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
    
    int tsum = 0;  // total sum
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        
        helper(root, 0);
        return tsum;
    }
    
    public void helper(TreeNode root, int rootToLeafPath){
        if (root == null) return;
        
        // Adding node value to path
        rootToLeafPath = rootToLeafPath *10 + root.val;
        
        // leaf node
        if (root.left == null && root.right == null) {
            tsum += rootToLeafPath;
            return;
        }
        
        helper(root.left, rootToLeafPath);
        helper(root.right, rootToLeafPath);
        
    }
}