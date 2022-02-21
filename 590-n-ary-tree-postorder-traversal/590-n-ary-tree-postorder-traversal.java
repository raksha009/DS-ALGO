/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        // Lc Rc Root
        ans = new ArrayList<>();
        if (root == null) return ans;
        
        helper(root);
        
        
        return ans;
    }
    
    public void helper(Node root){
        for (int i = 0; i < root.children.size(); i++){
            helper(root.children.get(i));
        }
        
        ans.add(root.val);
    }
}