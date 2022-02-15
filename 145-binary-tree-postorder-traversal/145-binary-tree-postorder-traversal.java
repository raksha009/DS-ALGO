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

// Way1: Recursive with internal stack SC: O(n)  TC:O(n)  (HERE)
// Way2: Iterative with external stack SC: O(n)  TC:O(n)
// Way3: Iterative SC: O(1)  TC:O(n)  === Morris Traversal 

class Solution {
    
    List<Integer> arr;
    public List<Integer> postorderTraversal(TreeNode root) {
        
        arr = new ArrayList<>();
        
        postorder(root);
        return arr;   
    }
    
    public void postorder(TreeNode root){
        
        if (root == null) return;
        
        postorder(root.left);
        postorder(root.right);
        arr.add(root.val);
    }
}