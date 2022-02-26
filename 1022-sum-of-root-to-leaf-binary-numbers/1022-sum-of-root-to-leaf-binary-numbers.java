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
    
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        String rootdata = "";
        helper(root, rootdata);
        
        return sum;
    }
    
    public void helper(TreeNode root, String path){
        // System.out.println(path);
    
        if (root == null) {
           return;
        }
        
        // Got a valid path
        if (root.left == null && root.right == null){
             sum += Integer.parseInt(path + String.valueOf(root.val),2);  
            return;
        }
        
        path = path + String.valueOf(root.val);
        helper(root.left, path );
        helper(root.right, path);
        
    }
}