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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        // edge case
        if (root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            
            level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode rem = q.poll();
                level.add(rem.val);
                
                if (rem.left != null) q.add(rem.left);
                if (rem.right != null) q.add(rem.right);
            }
            
            // 1 level ended
            ans.add(level);
            
        }
        return ans;
        
    }
}