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
    
    // Using reverse In order (i.e. Rc Root Lc) 
    // as since BST , greater nodes on right and also want decreasing order
    // => Inorder of BST given asc order => so, reverse Inorder gives desc order
    
    int currsum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        
        bstToGst(root.right);
        
        // Processing root
        currsum += root.val;
        root.val = currsum;
        
        bstToGst(root.left);
        return root;
    }
}