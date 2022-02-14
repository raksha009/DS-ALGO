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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        // Inorder Array stored in map <inorder[i], idx> for O(1) work and save traversal
        // Only possible since values are unique
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return inpre(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    
    public TreeNode inpre(int[] inorder, int[] preorder, int inS, int inE, int preS, int preE){
        if (inS > inE || preS > preE) return null;
        
        TreeNode root = new TreeNode(preorder[preS]);
        int idx = map.get(preorder[preS]);   // idx of root in inorder array
        int count = idx - inS;
        
        root.left = inpre(inorder, preorder, inS, inS+count-1, preS+1, preS+count);
        root.right = inpre(inorder, preorder, inS+count+1, inE, preS+count+1, preE);
        return root;
    }
}