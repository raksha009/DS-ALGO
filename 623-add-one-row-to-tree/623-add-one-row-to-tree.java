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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) return null;
        
        // depth == 1
        if (depth == 1){
            TreeNode newroot = new TreeNode(val);
            newroot.left = root;  // attaching it to left subtree as per ques
            return newroot;
        }
        
        helper(root, val, 1, depth);
        return root;
    }
    
    public void helper(TreeNode root, int val, int currDepth, int givenDepth){
        if (root == null) return;
        
        // Processing
        if (currDepth == givenDepth-1){
            TreeNode newNode1 = new TreeNode(val);
            newNode1.left = root.left;
            root.left = newNode1;
            
            TreeNode newNode2 = new TreeNode(val);
            newNode2.right = root.right;
            root.right = newNode2;
        }
        
        helper(root.left, val, currDepth+1, givenDepth);
        helper(root.right, val, currDepth+1, givenDepth);
    }
}