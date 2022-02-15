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

// Way1: Recursive with internal stack SC: O(n)  TC:O(n)  
// Way2: Iterative with external stack SC: O(n)  TC:O(n)
// Way3: Iterative SC: O(1)  TC:O(n)  === Morris Traversal (HERE) 

class Solution {
    
    List<Integer> arr;
    public List<Integer> postorderTraversal(TreeNode root) {
        
        arr = new ArrayList<>();
        
        // Morris Traversal only had Inorder and PreOrder
        // Using (Reverse PreOrder) ka reverse to find PostOrder
        
        reversePreOrderMorris(root);
        
        // Reversing (ReversePreOrder) to get Postorder
        Collections.reverse(arr);   
        return arr;
    }
    
    // Changing .right to .left and vice versa (of Preorder)
    public void reversePreOrderMorris(TreeNode root){
        
        if (root == null) return;
        
        TreeNode curr = root;
        while (curr != null){
            if (curr.right != null){
                TreeNode currp1 = curr.right;
                while (currp1.left != null && currp1.left != curr){
                    currp1 = currp1.left;
                }
                
                // 1st time visit => left nodes are yet to be processed
                // Form connection with curr and curr move left
                // Process left node n move ahead
                if (currp1.left == null) {
                    arr.add(curr.val);
                    currp1.left = curr;
                    curr = curr.right;
                }
                
                // 2nd time visit => all left nodes processed
                // Break connection and curr move right
                if (currp1.left == curr){
                    currp1.left = null;
                    curr = curr.left;
                }
                
            }else{
                // reached last level 
                arr.add(curr.val);  // Processed current node
                curr = curr.left;
                
            }
        }
    }
}