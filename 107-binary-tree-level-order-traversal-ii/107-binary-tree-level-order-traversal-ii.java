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
    
    // ITS REVERSE LEVEL ORDER TRAVERSAL KA REVERSE
    // i.e. Reverse Level Order = Node -> add Rc, add Lc => ans = 3 (20 9) (7 15)
    // on reversing it => get (15 7) (9 20) 3  ==== ans
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<Integer> level = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        // edge case
        if (root == null) return ans;
        
        // STEP1 -- REVERSE LEVEL ORDER FIND
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            
            level = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode rem = q.poll();
                level.add(rem.val);
                
                // ONLY CHANGE ORDER OF ADDING ELEM IN QUEUE
                if (rem.right != null) q.add(rem.right);  
                if (rem.left != null) q.add(rem.left);
                
            }
            
            // 1 level ended
            ans.add(level);
            
        }
        
        // Reversing --- STEP2
        Collections.reverse(ans);
        for (int i = 0; i < ans.size(); i++){
            Collections.reverse(ans.get(i));
        }
        return ans;
        
    }
}