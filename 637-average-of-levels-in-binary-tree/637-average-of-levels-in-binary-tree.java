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
    public List<Double> averageOfLevels(TreeNode root) {
        
        // Using Level Order Traversal
        
        List<Double> ans = new ArrayList<>();
        
        double sum = 0;
        
        // edge case
        if (root == null) return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            
            sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode rem = q.poll();
                sum += rem.val;
                
                if (rem.left != null) q.add(rem.left);
                if (rem.right != null) q.add(rem.right);
            }
            
            // 1 level ended
            ans.add(sum/size);  // adding average
            
        }
        return ans;
        
    }
}