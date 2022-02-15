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
    
    List<Integer> arr;
    public List<Integer> preorderTraversal(TreeNode root) {
        
        arr = new ArrayList<>();
        
        // Way1: Recursive with internal stack SC: O(n)  TC:O(n)
        preorder(root);
        return arr;   
    }
    
    public void preorder(TreeNode root){
        if (root == null) return;
        
        // Root processed
        arr.add(root.val);
        preorder(root.left);
        preorder(root.right);
        
    }
}