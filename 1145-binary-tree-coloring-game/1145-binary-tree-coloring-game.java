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
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xnode = findNode(root, x);
        
        int leftnodes = countNodes(xnode.left);  // OPTION 1
        int rightnodes = countNodes(xnode.right);  // OPTION 2
        
        int bluenodes = n - leftnodes - rightnodes - 1; // (x)  OPTION 3
        // System.out.println(leftnodes + " "+ rightnodes + " "+ bluenodes);
        return (bluenodes > (n/2)) || (leftnodes > (n/2)) || (rightnodes > (n/2));
    }
    
    public TreeNode findNode(TreeNode root, int x){
        if (root == null) return null;
        
        if (root.val == x) return root;
        
        TreeNode left = findNode(root.left,x);
        TreeNode right = findNode(root.right,x);
        
        if (left != null) return left;
        else return right;
    }
    
    public int countNodes(TreeNode root){
        if (root == null) return 0;
        
        int count = 0;
        count += countNodes(root.left);
        count += countNodes(root.right);
        
        return count + 1;  // +1 for current node
    }
}