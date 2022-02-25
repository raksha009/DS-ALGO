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
    public void flatten(TreeNode root) {
        
        flatternHelper(root);
    }
    
    public TreeNode flatternHelper(TreeNode root){
        if (root == null) return null;
        
        TreeNode lefttail = flatternHelper(root.left);
        TreeNode righttail = flatternHelper(root.right);
        
        if (lefttail == null && righttail == null) return root;
        else if (lefttail == null && righttail != null) return righttail;
        else if (lefttail != null && righttail == null){
            root.right = root.left;
            root.left = null;
            return lefttail;
        }else{
            lefttail.right = root.right;
            root.right = root.left;
            root.left = null;
            return righttail;
        }
        
    }
}