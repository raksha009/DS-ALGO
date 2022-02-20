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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        
        // Level Order Traversal  --- find max at each level
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (q.size() > 0){
            int size = q.size();
            
            int maxno = Integer.MIN_VALUE;
            for (int i = 0 ; i < size; i++){
                TreeNode rem = q.poll();
                maxno = Math.max(maxno, rem.val);
                
                if (rem.left != null) q.add(rem.left);
                if (rem.right != null) q.add(rem.right);
            }
            ans.add(maxno);
            
        }
        return ans;
    }
}