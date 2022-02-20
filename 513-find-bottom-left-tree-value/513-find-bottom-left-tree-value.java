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
    
    // APPROACH 1 ---------LEVEL ORDER
    /*
    public int findBottomLeftValue(TreeNode root) {
        
        
        // List<Integer> ans = new ArrayList<>();
        // if (root == null) return ans;
        int leftmostnode = 0;
        
        // Level Order Traversal  --- left view of bst
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0){
            int size = q.size();
            
            int maxno = Integer.MIN_VALUE;
            for (int i = 0 ; i < size; i++){
                TreeNode rem = q.poll();
                if (i == 0) leftmostnode = rem.val;
                
                if (rem.left != null) q.add(rem.left);
                if (rem.right != null) q.add(rem.right);
            }
            // ans.add(maxno);
            
        }
        return leftmostnode;
        
    }
    */
    
    // APPROACH 2 ------------ RECURSIVE
    int ans = 0;
    int h = 0;
    
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 1);
        return ans;
    }
    public void helper(TreeNode root, int depth){
        if (root == null) return;
        
        // Gone to deeper height
        if (h < depth){
            h = depth;
            ans = root.val;
        }
        // Always get leftmost node 1st when reach a new height as called Lc first
        helper(root.left, depth+1);
        helper(root.right, depth+1);
    }
}