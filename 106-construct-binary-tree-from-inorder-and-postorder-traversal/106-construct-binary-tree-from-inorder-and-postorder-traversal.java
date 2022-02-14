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

// Earlier done O(N2) work as O(n) work was done in each call - (traversal part in inorder array)
// Here, Time complexity = O(N) as O(1) work is done in each call
class Solution {
    
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // Inorder Array stored in map <inorder[i], idx> for O(1) work and save traversal
        // Only possible since values are unique
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return inpost(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode inpost(int[] inorder, int[] postorder, int inS, int inE, int postS, int postE){
        if (inS > inE || postS > postE) return null;
        
        TreeNode root = new TreeNode(postorder[postE]);
        int idx = map.get(postorder[postE]);   // idx of root in inorder array
        int count = idx - inS;
        
        root.left = inpost(inorder, postorder, inS, inS+count-1, postS, postS+count-1);
        root.right = inpost(inorder, postorder, idx+1, inE, postS+count, postE-1);
        return root;
    }
    
    
}