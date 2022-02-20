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
    
    TreeNode swappedNode1 = null;
    TreeNode swappedNode2 = null;
    
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        // Inorder  -> Increasing order in BST
        // Generally would get 2 dips 
        //but if adjacent elements are swapped, would get only 1 dip
        /*
        Approach1 :  Using O(n) space, write inorder traversal and find dips in array 
        1st dip ka 1st elem and 2nd dip ka 2md elem faulty
        */
        
        // Approach 2
        if (root == null) return;
        recoverTreehelper(root);
        
        int temp = swappedNode1.val;
        swappedNode1.val = swappedNode2.val;
        swappedNode2.val = temp;
        
    }
    
    public void recoverTreehelper(TreeNode root){
        if (root == null) return;
        recoverTreehelper(root.left);
        
        if (prev != null && prev.val > root.val){
            // dip
            if (swappedNode1 == null){  // 1st dip
                swappedNode1 = prev;
                swappedNode2 = root;
            }else{                      // 2nd dip
                swappedNode2 = root;
            }
        }
        
        prev = root;
        recoverTreehelper(root.right);
    }
}