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
// Way3: Iterative SC: O(1)  TC:O(n)  === Morris Traversal (Here)
class Solution {
    
    List<Integer> arr;
    public List<Integer> preorderTraversal(TreeNode root) {
        arr = new ArrayList<>();
        
        preorderMorris(root);
        return arr;   
    }
    
    public void preorderMorris(TreeNode root){
        
        TreeNode curr = root;
        while (curr != null){
            if (curr.left != null){
                TreeNode currp1 = curr.left;
                while (currp1.right != null && currp1.right != curr){
                    currp1 = currp1.right;
                }
                
                // 1st time visit => left nodes are yet to be processed
                // Form connection with curr and curr move left
                // Process left node n move ahead
                if (currp1.right == null) {
                    arr.add(curr.val);
                    currp1.right = curr;
                    curr = curr.left;
                }
                
                // 2nd time visit => all left nodes processed
                // Break connection and curr move right
                if (currp1.right == curr){
                    currp1.right = null;
                    curr = curr.right;
                }
                
            }else{
                // reached last level 
                arr.add(curr.val);  // Processed current node
                curr = curr.right;
                
            }
        }
        
    }
}