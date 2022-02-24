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

/*
NODE Type       MEANING
1               DUMMY LEAF NODE (CHILD NODE)
2               CAMERA PLACE
3               BEING WATCHED (PARENT NODE)
*/
class Solution {
    
    int camera = 0;
    public int minCameraCover(TreeNode root) {
        if (root == null) return camera;
        
        int node_type = placeCamera(root);
        if (node_type == 1) camera++;
        
        return camera;
    }
    
    public int placeCamera(TreeNode root){
        
        // NULL NODE-  as assumed watched => no work do for it
        if (root == null) return 3;
        
        // Leaf Node
        if (root.left == null && root.right == null) return 1;  
        
        int lans = placeCamera(root.left);
        int rans = placeCamera(root.right);
        
        // Place camera on current node as left and right child are dummy nodes
        if (lans == 1 || rans == 1){
            camera++;
            return 2;
        }
        
        // Being watched by any child
        else if (lans == 2 || rans == 2) return 3;
        else return 1;
    }
}
/*
CASES
LEFT    RIGHT   RETURN
1       1       2
1 or 2  2 or 1  2
1 or 3  3 or 1  2

2       2       3
2 or 3  3 or 2  3

3       3       1

*/